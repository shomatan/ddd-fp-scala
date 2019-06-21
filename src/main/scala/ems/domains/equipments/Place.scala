package ems.domains.equipments

import ems.domains.{Entity, Id}

case class PlaceName(value: String) extends AnyVal
case class PlaceDescription(value: String) extends AnyVal

case class Place(
  id: Id[Place],
  name: PlaceName,
  description: Option[PlaceDescription]
) extends Entity[Place]

