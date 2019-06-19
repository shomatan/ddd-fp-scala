package domains.equipments

sealed trait EquipmentError

case class EquipmentNotFound(id: EquipmentId) extends EquipmentError

