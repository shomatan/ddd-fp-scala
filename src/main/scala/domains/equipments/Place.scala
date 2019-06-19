package domains.equipments

import domains.Id

case class ValidatedPlace(
  id: Id[ValidatedPlace],
  name: String,
  description: Option[String]
)

case class UnValidatedPlace(
  id: Id[UnValidatedPlace],
  name: UnValidatedPlaceName,
  description: Option[String]
)
