package domains.equipments

import core.types.Result.Result

trait PlaceRepositoryAlg[F[_]] {
  def findById(id: PlaceId): Result[F, EquipmentError, Option[Place]]
  def store(place: Place): Result[F, EquipmentError, Place]
  def delete(place: Place): Result[F, EquipmentError, Unit]
}
