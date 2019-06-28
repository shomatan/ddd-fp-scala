package ems.domains.reservations

sealed trait ReservationState

// ReservationState is almost correct
// One state missing is rejected
// Cancelled mean the user has cancel by himself the reservation
// Rejected mean the staff may be able to reject one reservation manually
object ReservationState {
  case object Pending extends ReservationState
  case object Approved extends ReservationState
  case object Canceled extends ReservationState
  case object Placed extends ReservationState
}
