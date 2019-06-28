package ems.domains

import ems.domains.equipments.{Equipment, EquipmentState}

// Not really fan of this name it doesn't give an insight
// of what it should represent
// Each domain should contains the errors
// In this project reservation domain interact directly with equipment domain
// Then reservation domain include EquipmentError like
// type ReservationError = EquipmentError | ReservationNotFound[A](notFound: NotFound[A]) | ...
sealed trait DomainError

case class ValidationError() extends DomainError
case class EntityNotFound[A](id: Id[A]) extends DomainError

case class InvalidEquipmentState(state: EquipmentState) extends DomainError
case class EquipmentOutOfStock(equipment: Equipment) extends DomainError