package ems.domains.equipments

import ems.core.types.Result.Result
import ems.domains.Id

trait EquipmentRepositoryAlg {
  def findById(id: Id[Equipment]): Result[EquipmentError, Option[Equipment]]
  def store(equipment: Equipment): Result[EquipmentError, Equipment]
  def delete(equipment: Equipment): Result[EquipmentError, Unit]
}
