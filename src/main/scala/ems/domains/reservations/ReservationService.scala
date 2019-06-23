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
    def toDomainError: Either[DomainError, A] =
      result match {
        case Right(value) => Right(value)
        case Left(error) => Left(InEquipment(error))
      }
  }

  def requestReservation(unprocessedReservation: IncomingReservation): Result[DomainError, ReservationRequested] = {
    val unvalidated = Reservation.from(unprocessedReservation)

    val result = for {
      validatedReservation <- validate(unvalidated).handleError
      equipment <- equipmentRepository.findById(validatedReservation.equipmentId).handleError
      requestingEquipment <- EitherT.fromEither[Task](Equipment.reservationRequest(equipment).toDomainError)
      // TODO: needs transaction
      requestedReservation <- for {
        storedEquipment <- equipmentRepository.store(requestingEquipment).handleError
        storedReservation <- reservationRepository.store(validatedReservation).handleError
      } yield RequestedReservation(storedEquipment, storedReservation)
    } yield ReservationRequested(data = requestedReservation)

    result.value
  }

  def validate(unvalidated: UnvalidatedReservation): Result[DomainError, ValidatedReservation] = ???

}
