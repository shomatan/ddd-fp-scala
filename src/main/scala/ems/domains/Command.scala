package ems.domains

trait Command[T] {
  val data: T
}
