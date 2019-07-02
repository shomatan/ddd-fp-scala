package ems.domains.reservations

import ems.core.types.Validated
import shapeless.tag.@@

// Not really fan of this generic name in this place
// Better to rename ReservationTags
object ReservationTags {
  type ValidatedReservation = Reservation @@ Validated
}
