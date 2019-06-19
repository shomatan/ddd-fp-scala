package domains.equipments

import domains.Entity

case class Equipments(
  id: EquipmentsId,
  name: String,
  placeId: PlaceId
) extends Entity[EquipmentsId]

