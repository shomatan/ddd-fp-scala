package domains

trait Entity[T] {

  def id: Id[T]

  override def equals(obj: Any): Boolean =
    obj match {
      case that: Entity[_] => this.getClass == that.getClass && this.id == that.id
      case _ => false
    }

  override def hashCode(): Int = 31 + id.hashCode

}

