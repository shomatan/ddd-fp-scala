package ems.domains.equipments

sealed trait EquipmentState

object EquipmentState {
  case object Possible extends EquipmentState
  case class PreReserved() extends EquipmentState
  case class Reserved() extends EquipmentState
  case class Renting() extends EquipmentState
}
