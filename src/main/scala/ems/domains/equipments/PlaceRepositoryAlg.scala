package ems.domains.equipments

import ems.core.types.Result.AsyncResult
import ems.domains.Id

trait PlaceRepositoryAlg {
  def findById(id: Id[Place]): AsyncResult[EquipmentError, Option[Place]]
  def store(place: Place): AsyncResult[EquipmentError, Place]
  def delete(place: Place): AsyncResult[EquipmentError, Unit]
}
