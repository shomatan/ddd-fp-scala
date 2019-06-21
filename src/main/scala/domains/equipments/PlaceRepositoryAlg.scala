package domains.equipments

import core.types.Result.Result
import domains.Id
import domains.equipments.tags.ValidatedPlace

trait PlaceRepositoryAlg {
  def findById(id: Id[ValidatedPlace]): Result[EquipmentError, Option[ValidatedPlace]]
  def store(place: ValidatedPlace): Result[EquipmentError, ValidatedPlace]
  def delete(place: ValidatedPlace): Result[EquipmentError, Unit]
}
