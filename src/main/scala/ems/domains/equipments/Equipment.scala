package ems.domains.equipments

import ems.domains.equipments.EquipmentState.Free
import ems.domains.reservations.{InvalidEquipmentState, ReservationError}
import ems.shared.domains.{Entity, Id}

case class EquipmentName(value: String) extends AnyVal

// What about the stock ?
case class Equipment(
  id: Id[Equipment],
  name: EquipmentName,
  placeId: Id[Place],
  state: EquipmentState
) extends Entity[Equipment]

object Equipment {
  def reservationRequest(equipment: Equipment): Either[ReservationError, Equipment] =
    equipment.state match {
      case Free =>
        Right(equipment.copy(state = EquipmentState.Requesting))
      case other =>
        Left(InvalidEquipmentState(other))
    }
}

