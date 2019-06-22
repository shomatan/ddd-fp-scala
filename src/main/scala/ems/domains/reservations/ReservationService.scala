package ems.domains.reservations

import cats.data.EitherT
import ems.core.types.Result.{EquipmentResult, Result}
import ems.domains.{DomainError, InEquipment}
import ems.domains.equipments.{Equipment, EquipmentRepository}
import ems.domains.reservations.tags.ValidatedReservation
import monix.eval.Task

class ReservationService(equipmentRepository: EquipmentRepository,
                         reservationRepository: ReservationRepository) {

  import ems.core.types.Result.syntax._

  implicit class EquipmentOps[A](result: EquipmentResult[A]) {
    def toEquipmentError: Either[DomainError, A] =
      result match {
        case Right(value) => Right(value)
        case Left(error) => Left(InEquipment(error))
      }
  }

  def requestReservation(unprocessedReservation: UnprocessedReservation): Result[DomainError, ReservationRequested] = {
    val unvalidated = Reservation.from(unprocessedReservation)

    for {
      validatedReservation <- validate(unvalidated).handleError
      equipment <- equipmentRepository.findById(validatedReservation.equipmentId).handleError
      requestingEquipment <- EitherT.fromEither[Task](Equipment.reservationRequest(equipment).toEquipmentError)
      // TODO: needs transaction
      requestedReservation <- for {
        storedEquipment <- equipmentRepository.store (requestingEquipment).handleError
        storedReservation <- reservationRepository.store (validatedReservation).handleError
      } yield RequestedReservation(storedEquipment, storedReservation)
    } yield ReservationRequested(data = requestedReservation)
  }

  def validate(unvalidated: UnvalidatedReservation): Result[DomainError, ValidatedReservation] = ???

}
