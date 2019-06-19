package domains.equipments

case class EquipmentAggregate(
  equipment: ValidatedEquipment,
  place: ValidatedPlace
)
