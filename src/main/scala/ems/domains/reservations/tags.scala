package ems.domains.reservations

import ems.core.types.ValidatedTag
import shapeless.tag.@@

object tags {
  type ValidatedReservation = Reservation @@ ValidatedTag
}
