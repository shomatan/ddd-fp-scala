package domains.equipments

import domains.Entity

case class Equipment(
  id: EquipmentId,
  name: String,
  placeId: PlaceId
) extends Entity[EquipmentId]

