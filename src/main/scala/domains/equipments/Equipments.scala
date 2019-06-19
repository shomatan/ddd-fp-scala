package domains.equipments

import domains.Entity
import domains.places.PlaceId

case class Equipments(
  id: EquipmentsId,
  name: String,
  placeId: PlaceId
) extends Entity[EquipmentsId]

