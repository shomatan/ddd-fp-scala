package domains.places

import domains.Entity


case class Place(
  id: PlaceId,
  name: String,
  description: Option[String]
) extends Entity[PlaceId]
