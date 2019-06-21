package ems.domains.equipments

import ems.core.types.Result.EquipmentResult
import ems.domains.equipments.EquipmentState.Possible
import ems.domains.{Entity, Id}

case class EquipmentName(value: String) extends AnyVal

case class Equipment(
  id: Id[Equipment],
  name: EquipmentName,
  placeId: Id[Place],
  state: EquipmentState
) extends Entity[Equipment]

object Equipment {
  def preReserve(equipment: Equipment): EquipmentResult[Equipment] =
    equipment.state match {
      case Possible =>
        Right(equipment.copy(state = EquipmentState.PreReserved()))
      case other =>
        Left(InvalidState(other))
    }
}

