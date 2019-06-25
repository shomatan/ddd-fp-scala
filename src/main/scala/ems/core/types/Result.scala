package ems.core.types

import cats.data.EitherT
import ems.domains.equipments.EquipmentError
import ems.domains.{DomainError, EntityNotFound, Id}
import monix.eval.Task

object Result {

  type Result[E, A] = Task[Either[E, A]]

  def success[A](a: A): Result[Nothing, A] = Task {
    Right(a)
  }

  def error[E, A](error: E): Result[E, A] = Task {
    Left(error)
  }

  type EquipmentResult[A] = Either[EquipmentError, A]

  object syntax {

    implicit class ResultOps[E, A](result: Result[E, A]) {
      def handleError: EitherT[Task, E, A] =
        EitherT(result)

      def mapError[E2](f: E => E2): Result[E2, A] =
        result.flatMap { inner =>
          inner.fold(
            error => Result.error(f(error)),
            data => Result.success(data)
          )
        }

      def fromEither(result: Either[E, A]): EitherT[Task, E, A] =
        EitherT.fromEither[Task](result)
    }

    implicit class OptionOps[A](optValue: Option[A]) {
      def orNotFound(id: Id[A]): Either[DomainError, A] =
        optValue.map(Right(_)).getOrElse(Left(EntityNotFound(id)))
    }

    implicit class ResultOptionOps[A](result: Result[DomainError, Option[A]]) {
      def orNotFound(id: Id[A]): Result[DomainError, A] =
        result.map {
          case Right(optValue) => optValue orNotFound id
          case Left(error) => Left(error)
        }
    }
  }
}
