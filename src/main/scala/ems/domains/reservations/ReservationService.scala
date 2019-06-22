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
      validated <- validate(unvalidated).handleError
      equipment <- equipmentRepository.findById(validated.equipmentId).handleError
      requestingEquipment <- EitherT.fromEither[Task](Equipment.reservationRequest(equipment).toEquipmentError)
      // needs transaction
      storedEquipment <- storeEquipment(requestingEquipment).handleError
//      _ <- reservationRepository.store()
    } yield ()

    ???
  }

  def validate(unvalidated: UnvalidatedReservation): Result[DomainError, ValidatedReservation] = ???

  def storeEquipment(equipment: Equipment): Result[DomainError, Equipment] = ???

}
