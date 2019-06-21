package ems.domains.equipments

import ems.domains.{Entity, Id}

case class EquipmentName(value: String) extends AnyVal

case class Equipment(
  id: Id[Equipment],
  name: EquipmentName,
  placeId: Id[Place],
  state: EquipmentState
) extends Entity[Equipment]



