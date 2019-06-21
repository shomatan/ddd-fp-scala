package ems.domains.reservations

sealed trait ReservationState

object ReservationState {
  case object Pending extends ReservationState
  case object Approved extends ReservationState
  case object Canceled extends ReservationState
  case object Placed extends ReservationState
}
