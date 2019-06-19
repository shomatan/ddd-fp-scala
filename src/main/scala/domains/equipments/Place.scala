package domains.equipments

import domains.{Entity, Id}

case class PlaceId(value: Int) extends Id

case class Place(
  id: PlaceId,
  name: String,
  description: Option[String]
) extends Entity[PlaceId]
