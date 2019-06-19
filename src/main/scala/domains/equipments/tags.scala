package domains.equipments

import core.types.{UnValidatedTag, ValidatedTag}
import shapeless.tag.@@

object tags {
  type ValidatedEquipment = Equipment @@ ValidatedTag
  type UnValidatedEquipment = Equipment @@ UnValidatedTag

  type ValidatedPlace = Place @@ ValidatedTag
  type UnValidatedPlace = Place @@ UnValidatedTag

  type ValidatedEquipmentAggregate = EquipmentAggregate @@ ValidatedTag
  type UnValidatedEquipmentAggregate = EquipmentAggregate @@ UnValidatedTag
}
