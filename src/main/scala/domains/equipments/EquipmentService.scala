package domains.equipments

import cats.Monad
import core.types.Result.Result

class EquipmentService[F[_]: Monad](equipmentRepositoryAlg: EquipmentRepositoryAlg[F],
                                    placeRepositoryAlg: PlaceRepositoryAlg[F]) {
  import core.types.Result.syntax._

  def create(equipment: Equipment): Result[F, EquipmentError, Equipment] = {
    for {
      created <- equipmentRepositoryAlg.store(equipment).handleError
    } yield created

    ???
  }

//  def find(id: EquipmentId): Result
}