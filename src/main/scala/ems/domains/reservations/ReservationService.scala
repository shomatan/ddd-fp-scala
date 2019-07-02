package ems.domains.reservations

import ems.shared.Result
import ems.shared.Result.Result
import ems.domains.equipments.{Equipment, EquipmentRepository}
import ems.domains.reservations.ReservationTags.ValidatedReservation

class ReservationService(equipmentRepository: EquipmentRepository,
                         reservationRepository: ReservationRepository) {

  import ems.shared.Result.syntax._

  def requestReservation(incomingReservation: IncomingReservation): Result[ReservationError, RequestedReservation] = {
    val unvalidated = Reservation.from(incomingReservation)

    val result = for {
      validatedReservation <- validate(unvalidated).handleError
      equipment <- equipmentRepository.findById(validatedReservation.equipmentId).mapError(e => EquipmentError(e)).handleError
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
      requestedReservation <- reservationRepository.store(validatedReservation, requestingEquipment).handleError
    } yield requestedReservation

    result.value
  }

  def validate(unvalidated: UnvalidatedReservation): Result[ReservationError, ValidatedReservation] = ???

}
