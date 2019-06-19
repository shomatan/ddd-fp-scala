package domains.equipments

import core.types.Result.Result

trait EquipmentRepositoryAlg[F[_]] {
  def findById(id: EquipmentId): Result[F, EquipmentError, Option[Equipment]]
  def store(equipment: Equipment): Result[F, EquipmentError, Equipment]
  def delete(equipment: Equipment): Result[F, EquipmentError, Unit]
}
