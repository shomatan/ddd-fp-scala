package ems.domains.equipments

import ems.core.types.Result.Result
import ems.domains.DomainError

class EquipmentService(equipmentRepositoryAlg: EquipmentRepository,
                       placeRepositoryAlg: PlaceRepository) {

  def create(equipment: Equipment): Result[DomainError, Equipment] = {
//    for {
//      created <- equipmentRepositoryAlg.store(equipment).handleError
//    } yield created

    ???
  }

//  def find(id: EquipmentId): Result
}