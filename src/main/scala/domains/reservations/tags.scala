package domains.reservations

import core.types.{UnvalidatedTag, ValidatedTag}
import shapeless.tag.@@

object tags {
  type ValidatedReservation = Reservation @@ ValidatedTag
  type UnvalidatedReservation = Reservation @@ UnvalidatedTag
}
