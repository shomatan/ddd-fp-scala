package ems.domains.reservations

import ems.core.types.Result
import ems.core.types.Result.Result
import ems.domains.equipments.{Equipment, EquipmentChecked, EquipmentRepository, EquipmentState}
import ems.domains.reservations.tags.{UnvalidatedReservation, ValidatedReservation}
import ems.domains.{DomainError, EquipmentOutOfStock}

class ReservationService(equipmentRepository: EquipmentRepository) {

  import ems.core.types.Result.syntax._

  def reserve(unvalidatedReservation: UnvalidatedReservation): Result[DomainError, Reservation] = {

    for {
      validated <- validate(unvalidatedReservation).handleError
      equipment <- findEquipment(validated).handleError
      checked <- checkEquipment(equipment).handleError
      _ <- storeEquipment(checked).handleError
    } yield ()

    ???
  }

  def validate(unvalidated: UnvalidatedReservation): Result[DomainError, ValidatedReservation] = ???

  def findEquipment(validatedReservation: ValidatedReservation): Result[DomainError, Equipment] =
    equipmentRepository.findById(validatedReservation.equipmentId) orNotFound validatedReservation.equipmentId

  def checkEquipment(equipment: Equipment): Result[DomainError, EquipmentChecked] =
    equipment.state match {
      case EquipmentState.Possible => Result.success(EquipmentChecked(Equipment.preReserve(equipment)))
      case _ => Result.error(EquipmentOutOfStock(equipment))
    }

  def storeEquipment(checkedEquipment: EquipmentChecked): Result[DomainError, Unit] = ??? // TODO: return a result

}
