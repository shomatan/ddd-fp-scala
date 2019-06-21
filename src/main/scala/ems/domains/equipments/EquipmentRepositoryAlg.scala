package ems.domains.equipments

import ems.core.types.Result.AsyncResult
import ems.domains.{DomainError, Id}

trait EquipmentRepositoryAlg {
  def findById(id: Id[Equipment]): AsyncResult[DomainError, Option[Equipment]]
  def store(equipment: Equipment): AsyncResult[DomainError, Equipment]
  def delete(equipment: Equipment): AsyncResult[DomainError, Unit]
}
