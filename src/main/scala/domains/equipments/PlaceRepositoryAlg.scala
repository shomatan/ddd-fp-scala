package domains.equipments

import core.types.Result.Result
import domains.Id

trait PlaceRepositoryAlg {
  def findById(id: Id[Place]): Result[EquipmentError, Option[Place]]
  def store(place: Place): Result[EquipmentError, Place]
  def delete(place: Place): Result[EquipmentError, Unit]
}
