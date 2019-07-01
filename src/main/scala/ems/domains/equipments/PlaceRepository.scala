package ems.domains.equipments

import ems.core.types.Result.Result
import ems.domains.Id
import ems.domains.reservations.ReservationError

trait PlaceRepository {
  def findById(id: Id[Place]): Result[ReservationError, Option[Place]]
  def store(place: Place): Result[ReservationError, Place]
  def delete(place: Place): Result[ReservationError, Unit]
}
