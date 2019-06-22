package ems.domains.equipments

import ems.core.types.Result.EquipmentResult
import ems.domains.equipments.EquipmentState.Free
import ems.domains.{Entity, Id}

case class EquipmentName(value: String) extends AnyVal

case class Equipment(
  id: Id[Equipment],
  name: EquipmentName,
  placeId: Id[Place],
  state: EquipmentState
) extends Entity[Equipment]

object Equipment {
  def reservationRequest(equipment: Equipment): EquipmentResult[Equipment] =
    equipment.state match {
      case Free =>
        Right(equipment.copy(state = EquipmentState.Requesting))
      case other =>
        Left(InvalidState(other))
    }
}

