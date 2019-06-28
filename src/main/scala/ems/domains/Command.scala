package ems.domains

// Is there a need for a this generic type ?
// Is there a function or something that process a command from
// an abstract level ?
trait Command[T] {
  val data: T
}
