package domains.equipments

import domains.Id

case class EquipmentsId(value: Int) extends Id

case object UndefinedEquipmentId extends EquipmentsId(0)
