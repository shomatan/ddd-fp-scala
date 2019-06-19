package domains.equipments

import cats.Monad
import core.types.Result.Result
import domains.equipments.tags.{UnValidatedEquipment, ValidatedEquipment}

class EquipmentService[F[_]: Monad](equipmentRepositoryAlg: EquipmentRepositoryAlg[F],
                                    placeRepositoryAlg: PlaceRepositoryAlg[F]) {

  def create(equipment: UnValidatedEquipment): Result[F, EquipmentError, ValidatedEquipment] = {
//    for {
//      created <- equipmentRepositoryAlg.store(equipment).handleError
//    } yield created

    ???
  }

//  def find(id: EquipmentId): Result
}