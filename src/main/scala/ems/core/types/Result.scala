package ems.core.types

import cats.data.EitherT
import monix.eval.Task

object Result {

  type Result[E, A] = Task[Either[E, A]]

  def success[A](a: A): Result[Nothing, A] = Task {
    Right(a)
  }

  def error[E, A](error: E): Result[E, A] = Task {
    Left(error)
  }

  def fromEither[E, A](result: Either[E, A]): Result[E, A] =
    Task(result)

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
    }

//    implicit class OptionOps[A](optValue: Option[A]) {
//      def orNotFound(id: Id[A]): Either[ReservationError, A] =
//        optValue.map(Right(_)).getOrElse(Left(EntityNotFound(id)))
//    }
//
//    implicit class ResultOptionOps[A](result: Result[ReservationError, Option[A]]) {
//      def orNotFound(id: Id[A]): Result[ReservationError, A] =
//        result.map {
//          case Right(optValue) => optValue.orNotFound(id)
//          case Left(error) => Left(error)
//        }
//    }
  }
}
