package domains

case class Id[T](value: T) extends AnyVal

sealed trait Entity[T] {
  def id: Id[T]
}

