package core.types

import cats.Monad
import cats.data.EitherT


object Result {
  type Result[F[_], E, A] = F[Either[E, A]]

  def success[F[_]: Monad, A](a: A): Result[F, Nothing, A] = {
    val monadInstance = implicitly[Monad[F]]
    monadInstance.pure(Right(a))
  }
  def error[F[_]: Monad, E, A](error: E): Result[F, E, A] = {
    val monadInstance = implicitly[Monad[F]]
    monadInstance.pure(Left(error))
  }
  object syntax {
    implicit class ResultOps[F[_], E, A](result: Result[F, E, A]) {
      def handleError: EitherT[F, E, A] =
        EitherT(result)
    }
  }
}
