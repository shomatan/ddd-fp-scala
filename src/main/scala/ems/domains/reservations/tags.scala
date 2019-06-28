package ems.domains.reservations

import ems.core.types.ValidatedTag
import shapeless.tag.@@

// Not really fan of this generic name in this place
// Better to rename ReservationTags
object tags {
  type ValidatedReservation = Reservation @@ ValidatedTag
}
