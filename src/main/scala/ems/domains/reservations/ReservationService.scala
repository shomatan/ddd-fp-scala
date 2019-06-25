package ems.domains.reservations

import cats.data.EitherT
import ems.core.types.Result
import ems.core.types.Result.{EquipmentResult, Result}
import ems.domains.{DomainError, InEquipment}
import ems.domains.equipments.{Equipment, EquipmentError, EquipmentRepository}
import ems.domains.reservations.tags.ValidatedReservation
import monix.eval.Task

class ReservationService(equipmentRepository: EquipmentRepository,
                         reservationRepository: ReservationRepository) {

  import ems.core.types.Result.syntax._

  def requestReservation(incomingReservation: IncomingReservation): Result[DomainError, ReservationRequested] = {
    val unvalidated = Reservation.from(incomingReservation)

    val result = for {
      validatedReservation <- validate(unvalidated).handleError
      equipment <- equipmentRepository.findById(validatedReservation.equipmentId).handleError
      requestingEquipment <- {

        val a = Equipment.reservationRequest(equipment).fromEither

        a
        ???
      }
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
