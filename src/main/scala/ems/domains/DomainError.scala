package ems.domains

import ems.domains.equipments.{Equipment, EquipmentError}

sealed trait DomainError

case class ValidationError() extends DomainError
case class EntityNotFound[A](id: Id[A]) extends DomainError
case class InEquipment(error: EquipmentError) extends DomainError
case class EquipmentOutOfStock(equipment: Equipment) extends DomainError