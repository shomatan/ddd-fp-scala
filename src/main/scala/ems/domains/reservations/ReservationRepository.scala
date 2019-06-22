package ems.domains.reservations

import ems.core.types.Result.Result
import ems.domains.DomainError

trait ReservationRepository {
  def store(reservation: Reservation): Result[DomainError, Reservation]
}
