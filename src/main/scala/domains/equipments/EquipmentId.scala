package domains.equipments

import domains.Id

case class EquipmentId(value: Int) extends AnyVal with Id


object EquipmentId {
  def undefined: EquipmentId = EquipmentId(0)
}