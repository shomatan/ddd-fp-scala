package domains.equipments

import core.types.Result.Result
import domains.Id

trait EquipmentRepositoryAlg[F[_]] {
  def findById(id: Id[ValidatedEquipment]): Result[F, EquipmentError, Option[ValidatedEquipment]]
  def store(equipment: ValidatedEquipment): Result[F, EquipmentError, ValidatedEquipment]
  def delete(equipment: ValidatedEquipment): Result[F, EquipmentError, Unit]
}
