package domains.equipments

import core.types.Result.Result

trait PlaceRepositoryAlg[F[_]] {
  def findById(id: PlaceId): Result[F, PlaceError, Option[Place]]
  def store(place: Place): Result[F, PlaceError, Place]
  def delete(place: Place): Result[F, PlaceError, Unit]
}
