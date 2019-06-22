package ems.domains.equipments

sealed trait EquipmentState

object EquipmentState {
  case object Free extends EquipmentState
  case object Requesting extends EquipmentState
  case class Reserved() extends EquipmentState
  case class Renting() extends EquipmentState
}
