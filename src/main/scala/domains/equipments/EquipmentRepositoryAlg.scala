package domains.equipments

import core.types.Result.Result
import domains.Id
import domains.equipments.tags.ValidatedEquipment

trait EquipmentRepositoryAlg {
  def findById(id: Id[ValidatedEquipment]): Result[EquipmentError, Option[ValidatedEquipment]]
  def store(equipment: ValidatedEquipment): Result[EquipmentError, ValidatedEquipment]
  def delete(equipment: ValidatedEquipment): Result[EquipmentError, Unit]
}
