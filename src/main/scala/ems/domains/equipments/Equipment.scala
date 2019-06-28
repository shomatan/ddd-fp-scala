package ems.domains.equipments

import ems.domains.equipments.EquipmentState.Free
import ems.domains.{DomainError, Entity, Id, InvalidEquipmentState}

case class EquipmentName(value: String) extends AnyVal

// What about the stock ?
case class Equipment(
  id: Id[Equipment],
  name: EquipmentName,
  placeId: Id[Place],
  state: EquipmentState
) extends Entity[Equipment]

object Equipment {
  def reservationRequest(equipment: Equipment): Either[DomainError, Equipment] =
    equipment.state match {
      case Free =>
        Right(equipment.copy(state = EquipmentState.Requesting))
      case other =>
        Left(InvalidEquipmentState(other))
    }
}

