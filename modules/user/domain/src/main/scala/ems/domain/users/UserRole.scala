package ems.domain.users

sealed trait UserRole

object UserRole {
  case object Administrator extends UserRole
  case object Employee extends UserRole
  case object Receptionist extends UserRole
}
