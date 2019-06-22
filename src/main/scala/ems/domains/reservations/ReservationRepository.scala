package ems.domains.reservations

import ems.core.types.Result.Result
import ems.domains.DomainError
import ems.domains.reservations.tags.ValidatedReservation

trait ReservationRepository {
  def store(reservation: ValidatedReservation): Result[DomainError, ValidatedReservation]
}
