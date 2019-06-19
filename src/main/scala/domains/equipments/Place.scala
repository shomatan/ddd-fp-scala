package domains.equipments

import domains.{Entity, Id}

case class PlaceId(value: Int) extends Id

case class Place(id: PlaceId) extends Entity[PlaceId]
