package ems.domains.reservations

import ems.core.types.Result.Result
import ems.domains.equipments.{Equipment, EquipmentRepository}
import ems.domains.reservations.tags.{UnvalidatedReservation, ValidatedReservation}
import ems.domains.{DomainError}

class ReservationService(equipmentRepository: EquipmentRepository) {

  import ems.core.types.Result.syntax._

  def reserve(unvalidatedReservation: UnvalidatedReservation): Result[DomainError, Reservation] = {

    for {
      validated <- validate(unvalidatedReservation).handleError
      equipment <- equipmentRepository.findById(validated.equipmentId).handleError
      preReservedEquipment = Equipment.preReserve(equipment)
      _ <- storeEquipment(preReservedEquipment).handleError
    } yield ()

    ???
  }

  def validate(unvalidated: UnvalidatedReservation): Result[DomainError, ValidatedReservation] = ???

  def storeEquipment(equipment: Equipment): Result[DomainError, Unit] = ??? // TODO: return a result

}
