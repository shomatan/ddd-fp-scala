package domains.equipments

import domains.Entity
import domains.places.PlaceId

case class Equipment(
  id: EquipmentId,
  name: String,
  placeId: PlaceId
) extends Entity[EquipmentId]

