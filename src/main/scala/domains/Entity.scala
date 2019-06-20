package domains

case class Id[T](value: T) extends AnyVal

trait Entity[T] {
  def id: Id[T]
}

