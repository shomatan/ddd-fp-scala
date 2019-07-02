package ems.domain.users

import ems.shared.domains.{Entity, Id}

case class EmployeeName(value: String) extends AnyVal

case class Employee(
  id: Id[Employee],
  name: EmployeeName
) extends Entity[Employee]
