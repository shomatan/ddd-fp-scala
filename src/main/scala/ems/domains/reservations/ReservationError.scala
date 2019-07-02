package ems.domains.reservations

import ems.domains.Id
import ems.domains.equipments.{Equipment, EquipmentState}

// Not really fan of this name it doesn't give an insight
// of what it should represent
// Each domain should contains the errors
// In this project reservation domain interact directly with equipment domain
// Then reservation domain include EquipmentError like
// type ReservationError = EquipmentError | ReservationNotFound[A](notFound: NotFound[A]) | ...
sealed trait ReservationError

case class EquipmentError(equipmentError: ems.domains.equipments.EquipmentError) extends ReservationError
case class ReservationNotFound(id: Id[Reservation]) extends ReservationError
case class InvalidEquipmentState(state: EquipmentState) extends ReservationError
case class EquipmentOutOfStock(equipment: Equipment) extends ReservationError