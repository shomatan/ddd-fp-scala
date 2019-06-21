package ems.core.types

import cats.data.EitherT
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

  object syntax {
//    implicit class ResultOps[E, A](result: Result[E, A]) {
//      def handleError: EitherT[E, A] =
//        EitherT(result)
//    }

    implicit class ResultOps[E, A](result: Result[E, A]) {
      def handleError: EitherT[Task, E, A] =
        EitherT(result)
    }

    implicit class OptionOps[A](optValue: Option[A]) {
      def orNotFound(id: Id[A]): Either[DomainError, A] =
        optValue.map(Right(_)).getOrElse(Left(EntityNotFound(id)))
    }

    implicit class AsyncOptionOps[A](asyncResult: Result[DomainError, Option[A]]) {
      def orNotFound(id: Id[A]): Result[DomainError, A] =
        asyncResult.map {
          case Right(optValue) => optValue orNotFound id
          case Left(error) => Left(error)
        }
    }
  }
}
