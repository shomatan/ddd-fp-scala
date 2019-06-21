package ems.domains.reservations

import ems.core.types.{UnvalidatedTag, ValidatedTag}
import shapeless.tag.@@

object tags {
  type ValidatedReservation = Reservation @@ ValidatedTag
  type UnvalidatedReservation = Reservation @@ UnvalidatedTag
}
