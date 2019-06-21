package ems.domains.reservations

import ems.domains.{Entity, Id}

case class Reservation(
  id: Id[Reservation]
) extends Entity[Reservation]
