package ems.domains.reservations

import ems.core.types.Result.AsyncResult
import ems.domains.{DomainError, EntityNotFound, Id}
import ems.domains.equipments.{Equipment, EquipmentRepositoryAlg}
import ems.domains.reservations.tags.{UnvalidatedReservation, ValidatedReservation}

class ReservationService(equipmentRepository: EquipmentRepositoryAlg) {

  implicit class OptionOps[A](optValue: Option[A]) {
    def orNotFound(id: Id[A]): Either[DomainError, A] =
      optValue.map(Right(_)).getOrElse(Left(EntityNotFound(id)))
  }

  def reserve(unvalidatedReservation: UnvalidatedReservation): AsyncResult[DomainError, Reservation] = {

//    for {
//      validated <- validate(unvalidatedReservation)
//      checked <- checkEquipment(validated)
//      _ <-
//    } yield ()

    ???
  }

  def validate(unvalidated: UnvalidatedReservation): AsyncResult[DomainError, ValidatedReservation] = ???

  def checkEquipment(validatedReservation: ValidatedReservation): AsyncResult[DomainError, Equipment] =
    equipmentRepository.findById(validatedReservation.equipmentId).map {
      case Right(optEquipment) => optEquipment orNotFound validatedReservation.equipmentId
      case Left(error) => Left(error)
    }

}
