package ems.domains.equipments

import ems.core.types.Result.Result

class EquipmentService(equipmentRepositoryAlg: EquipmentRepositoryAlg,
                       placeRepositoryAlg: PlaceRepositoryAlg) {

  def create(equipment: Equipment): Result[EquipmentError, Equipment] = {
//    for {
//      created <- equipmentRepositoryAlg.store(equipment).handleError
//    } yield created

    ???
  }

//  def find(id: EquipmentId): Result
}