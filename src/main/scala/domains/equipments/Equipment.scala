package domains.equipments

import domains.Id

case class ValidatedEquipment(
  id: Id[ValidatedEquipment],
  name: ValidatedEquipmentName,
  placeId: Id[ValidatedPlace]
)

case class UnValidatedEquipment(
  id: Id[UnValidatedEquipment],
  name: UnValidatedEquipmentName,
  placeId: Id[UnValidatedEquipment]
)


