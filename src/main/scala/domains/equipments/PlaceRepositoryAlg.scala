package domains.equipments

import core.types.Result.Result
import domains.Id

trait PlaceRepositoryAlg[F[_]] {
  def findById(id: Id[ValidatedPlace]): Result[F, EquipmentError, Option[ValidatedPlace]]
  def store(place: ValidatedPlace): Result[F, EquipmentError, ValidatedPlace]
  def delete(place: ValidatedPlace): Result[F, EquipmentError, Unit]
}
