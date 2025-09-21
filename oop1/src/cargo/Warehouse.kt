package cargo

class Warehouse {
    fun getPack(deliveryObject: DeliveryObject) : Pack {
        val pack = Pack(
            length = deliveryObject.length + 1,
            width = deliveryObject.width + 1,
            height = deliveryObject.height + 1,
            weight = 0.3
        )
        return pack
    }

    fun packCargo(deliveryObject: DeliveryObject) : Cargo {
        val pack = getPack(deliveryObject)
        val cargo = Cargo(
            length = pack.length,
            width = pack.width,
            height = pack.height,
            typePackaging = pack.type,
            netWeight = deliveryObject.weight,
            grossWeight = deliveryObject.weight + pack.weight
        )
        return cargo
    }
}