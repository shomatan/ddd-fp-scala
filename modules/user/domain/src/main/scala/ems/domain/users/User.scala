package ems.domain.users

import ems.shared.domains.{Entity, Id}
import shapeless.tag
import shapeless.tag.@@

case class User(
  id: Id[User],
  name: UserName,
  role: UserRole,
  state: UserState
) extends Entity[User]

object UserTags {
  sealed trait Administrator
  sealed trait Employee
  sealed trait Receptionist

  type UserOfAdministrator = User @@ Administrator
  type UserOfEmployee = User @@ Employee
  type UserOfReceptionist = User @@ Receptionist
}

object User {

  import UserTags._

  def createAdministrator(id: Id[User], name: UserName, state: UserState): UserOfAdministrator =
    tag[Administrator][User](User(id = id, name = name, role = UserRole.Administrator, state = state))

  def createEmployee(id: Id[User], name: UserName, state: UserState): UserOfEmployee =
    tag[Employee][User](User(id = id, name = name, role = UserRole.Employee, state = state))

  def createReceptionist(id: Id[User], name: UserName, state: UserState): UserOfReceptionist =
    tag[Receptionist][User](User(id = id, name = name, role = UserRole.Receptionist, state = state))

}
