package ems.domain

import shapeless.tag.@@

package object users {
  sealed trait Administrator
  sealed trait Employee
  sealed trait Receptionist

  type UserOfAdministrator = User @@ Administrator
  type UserOfEmployee = User @@ Employee
  type UserOfReceptionist = User @@ Receptionist
}
