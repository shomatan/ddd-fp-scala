package ems.core.types

import monix.eval.Task

object Result {

  type Result[E, A] = Task[Either[E, A]]

  def success[A](a: A): Result[Nothing, A] = Task {
    Right(a)
  }

  def error[E, A](error: E): Result[E, A] = Task {
    Left(error)
  }

//  object syntax {
//    implicit class ResultOps[E, A](result: Result[E, A]) {
//      def handleError: EitherT[E, A] =
//        EitherT(result)
//    }
//  }
}
