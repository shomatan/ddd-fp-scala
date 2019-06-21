package ems.domains.equipments

sealed trait EquipmentError

case class InvalidState(state: EquipmentState) extends EquipmentError