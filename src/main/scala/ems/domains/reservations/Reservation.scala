package ems.domains.reservations

import ems.domains.equipments.Equipment
import ems.domains.{Command, Entity, Id}

case class Reservation(
  id: Id[Reservation],
  equipmentId: Id[Equipment],
  state: ReservationState
) extends Entity[Reservation]

object Reservation {
  def from(unprocessedReservation: UnprocessedReservation): UnvalidatedReservation =
    UnvalidatedReservation(
      equipmentId = unprocessedReservation.equipmentId,
    )
}

case class UnprocessedReservation(
  equipmentId: Id[Equipment]
)

case class UnvalidatedReservation(
  equipmentId: Id[Equipment]
)

case class RequestedReservation(
  equipment: Equipment,
  reservation: Reservation
)

case class ReservationRequested(
  data: RequestedReservation
) extends Command[RequestedReservation]