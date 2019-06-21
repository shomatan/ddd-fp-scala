package ems.domains.reservations

import ems.domains.equipments.Equipment
import ems.domains.{Entity, Id}

case class Reservation(
  id: Id[Reservation],
  equipmentId: Id[Equipment],
  state: ReservationState
) extends Entity[Reservation]

