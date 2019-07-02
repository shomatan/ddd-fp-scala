package ems.domains.equipments

import ems.shared.Result.Result
import ems.domains.Id

// If you read the chapter about how to not design from the database
// This part make no sense anymore
// And this chapter is very good to explain why it isn't such a good idea
// Storage should gather aggregate not entity it makes much more sense
// and free you from tighing your application to the storage
// Storage should just be a way to gather data and store it
trait EquipmentRepository {

  def findById(id: Id[Equipment]): Result[EquipmentError, Equipment] =
    findByIdOpt(id).map {
      case Right(value) => value.map(Right(_)).getOrElse(Left(EquipmentNotFound(id)))
      case Left(error) => Left(error)
    }

  def findByIdOpt(id: Id[Equipment]): Result[EquipmentError, Option[Equipment]]
  def store(equipment: Equipment): Result[EquipmentError, Equipment]
  def delete(equipment: Equipment): Result[EquipmentError, Unit]
}
