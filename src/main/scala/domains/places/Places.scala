package domains.places

import domains.equipments.PlaceId

trait Places[F[_]] {
  def findById(placeId: PlaceId): F[Option[Place]]
  def store(place: Place): F[Place]
  def delete(place: Place)
}
