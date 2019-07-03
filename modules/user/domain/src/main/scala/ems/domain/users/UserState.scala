package ems.domain.users

sealed trait UserState

object UserState {
  case object Active extends UserState
  case object InActive extends UserState
}
