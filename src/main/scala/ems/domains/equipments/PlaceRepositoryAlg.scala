package ems.domains.equipments

import ems.core.types.Result.Result
import ems.domains.{DomainError, Id}

trait PlaceRepositoryAlg {
  def findById(id: Id[Place]): Result[DomainError, Option[Place]]
  def store(place: Place): Result[DomainError, Place]
  def delete(place: Place): Result[DomainError, Unit]
}
