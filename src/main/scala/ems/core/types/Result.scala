package ems.core.types

import monix.eval.Task

object Result {

  type Result[E, A] = Either[E, A]
  type AsyncResult[E, A] = Task[Result[E, A]]

  def success[A](a: A): AsyncResult[Nothing, A] = Task {
    Right(a)
  }

  def error[E, A](error: E): AsyncResult[E, A] = Task {
    Left(error)
  }

//  object syntax {
//    implicit class ResultOps[E, A](result: Result[E, A]) {
//      def handleError: EitherT[E, A] =
//        EitherT(result)
//    }
//  }
}
