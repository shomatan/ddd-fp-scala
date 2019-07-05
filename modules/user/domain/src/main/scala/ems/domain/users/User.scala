package ems.domain.users

import ems.shared.domains.{Entity, Id}

case class User(
  id: Id[User],
  name: UserName,
  role: UserRole,
  state: UserState
) extends Entity[User]

object User {

  def createAdministrator(id: Id[User], name: UserName, state: UserState): UserOfAdministrator =
    shapeless.tag[Administrator][User](User(id = id, name = name, role = UserRole.Administrator, state = state))

  def createEmployee(id: Id[User], name: UserName, state: UserState): UserOfEmployee =
    shapeless.tag[Employee][User](User(id = id, name = name, role = UserRole.Employee, state = state))

  def createReceptionist(id: Id[User], name: UserName, state: UserState): UserOfReceptionist =
    shapeless.tag[Receptionist][User](User(id = id, name = name, role = UserRole.Receptionist, state = state))

}
