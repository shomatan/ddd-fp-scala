package ems.domains

sealed trait DomainError

case class ValidationError() extends DomainError
case class EquipmentError() extends DomainError
case class EntityNotFound[A](id: Id[A]) extends DomainError
case class EquipmentOutOfStock() extends DomainError