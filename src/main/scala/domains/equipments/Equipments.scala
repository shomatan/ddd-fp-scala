package domains.equipments

import domains.{Entity, Id}

case class EquipmentsId(value: Int) extends Id

case class Equipments(
  id: EquipmentsId,
  name: String,
  place: Place
) extends Entity[EquipmentsId]
