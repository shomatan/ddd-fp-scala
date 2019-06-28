package ems.domains.reservations

import ems.domains.equipments.Equipment
import ems.domains.{Command, Entity, Id}

// Reservation is a domain entity
// One reservation is linked to one equipment here
// One user request can create multiple reservation for
// different equipment
case class Reservation(
  id: Id[Reservation],
  equipmentId: Id[Equipment],
  state: ReservationState
) extends Entity[Reservation]

object Reservation {
  def from(incomingReservation: IncomingReservation): UnvalidatedReservation =
    UnvalidatedReservation(
      equipmentId = incomingReservation.equipmentId,
    )
}

// This and UnvalidatedReservation are quite similar
// They are synonym
// An IncomingReservation
// Maybe this one should be a command like RequestReservation
// This should contains the information about who ask it, what equipment the user
// want to reserve and the number of it
// Also an user may ask to reserve multiple equipment
case class IncomingReservation(
  equipmentId: Id[Equipment]
)

// Probably no need for that
case class UnvalidatedReservation(
  equipmentId: Id[Equipment]
)

case class RequestedReservation(
  equipment: Equipment,
  reservation: Reservation
)

// This name sounds more like an event than a command to me
// The name is already in the past
case class ReservationRequested(
  data: RequestedReservation
) extends Command[RequestedReservation]