package ems.domains.reservations

import ems.core.types.Result.Result
import ems.domains.DomainError
import ems.domains.equipments.{Equipment, EquipmentRepository}
import ems.domains.reservations.tags.ValidatedReservation

class ReservationService(equipmentRepository: EquipmentRepository,
                         reservationRepository: ReservationRepository) {

  import ems.core.types.Result.syntax._

  def requestReservation(incomingReservation: IncomingReservation): Result[DomainError, ReservationRequested] = {
    val unvalidated = Reservation.from(incomingReservation)

    val result = for {
      validatedReservation <- validate(unvalidated).handleError
      equipment <- equipmentRepository.findById(validatedReservation.equipmentId).handleError
      requestingEquipment <- Equipment.reservationRequest(equipment).fromEither.value.handleError
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
