package ems.domains.equipments

import ems.domains.Id

sealed trait EquipmentError

case class EquipmentNotFound(id: Id[Equipment]) extends EquipmentError

