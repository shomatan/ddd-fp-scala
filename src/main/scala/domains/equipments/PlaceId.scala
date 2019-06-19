package domains.equipments

import domains.Id

case class PlaceId(value: Int) extends Id

object PlaceId {
  def undefined: PlaceId = PlaceId(0)
}
