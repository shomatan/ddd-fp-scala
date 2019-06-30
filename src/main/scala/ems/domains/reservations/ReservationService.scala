package ems.domains.reservations

import ems.core.types.Result
import ems.core.types.Result.Result
import ems.domains.DomainError
import ems.domains.equipments.{Equipment, EquipmentRepository}
import ems.domains.reservations.ReservationTags.ValidatedReservation

class ReservationService(equipmentRepository: EquipmentRepository,
                         reservationRepository: ReservationRepository) {

  import ems.core.types.Result.syntax._

  def requestReservation(incomingReservation: IncomingReservation): Result[DomainError, RequestedReservation] = {
    val unvalidated = Reservation.from(incomingReservation)

    val result = for {
      validatedReservation <- validate(unvalidated).handleError
      equipment <- equipmentRepository.findById(validatedReservation.equipmentId).handleError
      requestingEquipment <- Result.fromEither(Equipment.reservationRequest(equipment)).handleError
      // TODO: needs transaction
      // Depends if you ends up using domain events or not
      // could be simple as if not using eve
      // transactionally {
      //   for {
      //      storedEquipment <- equipmentRepository.store(requestingEquipment).handleError
      //      storedReservation <- reservationRepository.store(validatedReservation).handleError
      //   } yield RequestedReservation(storedEquipment, storedReservation)
      // }
      requestedReservation <- for {
        storedEquipment <- equipmentRepository.store(requestingEquipment).handleError
        storedReservation <- reservationRepository.store(validatedReservation).handleError
      } yield RequestedReservation(storedEquipment, storedReservation)
    } yield requestedReservation

    result.value
  }

  def validate(unvalidated: UnvalidatedReservation): Result[DomainError, ValidatedReservation] = ???

}
