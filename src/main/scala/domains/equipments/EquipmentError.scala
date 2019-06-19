package domains.equipments

import domains.Id

sealed trait EquipmentError

case class EquipmentNotFound(id: Id[Equipment]) extends EquipmentError

