package ems.domains.equipments

import ems.shared.Result.Result
import ems.domains.reservations.ReservationError

class EquipmentService(equipmentRepositoryAlg: EquipmentRepository,
                       placeRepositoryAlg: PlaceRepository) {

  def create(equipment: Equipment): Result[ReservationError, Equipment] = {
//    for {
//      created <- equipmentRepositoryAlg.store(equipment).handleError
//    } yield created

    ???
  }

//  def find(id: EquipmentId): Result
}