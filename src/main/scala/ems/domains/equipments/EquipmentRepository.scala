package ems.domains.equipments

import ems.core.types.Result.Result
import ems.domains.{DomainError, Id}

trait EquipmentRepository {
  import ems.core.types.Result.syntax._

  def findById(id: Id[Equipment]): Result[DomainError, Equipment] = findByIdOpt(id) orNotFound id

  def findByIdOpt(id: Id[Equipment]): Result[DomainError, Option[Equipment]]
  def store(equipment: Equipment): Result[DomainError, Equipment]
  def delete(equipment: Equipment): Result[DomainError, Unit]
}
