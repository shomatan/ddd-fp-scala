package ems.domains.equipments

import ems.shared.domains.Id

sealed trait EquipmentError

case class EquipmentNotFound(id: Id[Equipment]) extends EquipmentError