package ems.domains.equipments

import ems.core.types.Result.Result
import ems.domains.{DomainError, Id}

// If you read the chapter about how to not design from the database
// This part make no sense anymore
// And this chapter is very good to explain why it isn't such a good idea
// Storage should gather aggregate not entity it makes much more sense
// and free you from tighing your application to the storage
// Storage should just be a way to gather data and store it
trait EquipmentRepository {
  import ems.core.types.Result.syntax._

  def findById(id: Id[Equipment]): Result[DomainError, Equipment] = findByIdOpt(id) orNotFound id

  def findByIdOpt(id: Id[Equipment]): Result[DomainError, Option[Equipment]]
  def store(equipment: Equipment): Result[DomainError, Equipment]
  def delete(equipment: Equipment): Result[DomainError, Unit]
}
