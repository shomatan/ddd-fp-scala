package domains.equipments

import domains.Id

case class EquipmentName(value: String) extends AnyVal

case class Equipment(
  id: Id[Equipment],
  name: EquipmentName,
  placeId: Id[Place]
)



