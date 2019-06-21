package domains.reservations

import domains.{Entity, Id}

case class Reservation(
  id: Id[Reservation]
) extends Entity[Reservation]
