package domains.equipments

import core.types.Result.Result
import domains.equipments.tags.{UnValidatedEquipment, ValidatedEquipment}

class EquipmentService(equipmentRepositoryAlg: EquipmentRepositoryAlg,
                       placeRepositoryAlg: PlaceRepositoryAlg) {

  def create(equipment: UnValidatedEquipment): Result[EquipmentError, ValidatedEquipment] = {
//    for {
//      created <- equipmentRepositoryAlg.store(equipment).handleError
//    } yield created

    ???
  }

//  def find(id: EquipmentId): Result
}