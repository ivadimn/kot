package par613

class Light {
    fun turnOn() = println("Свет включен")
    fun turnOff() = println("Свет выключен")
}

class TV {
    fun turnOn() = println("Телевизор включен")
    fun turnOff() = println("Телевизор выключен")
    fun changeChannel(channel: Int) = println("Канал переключен на $channel")
}

class AirConditioner {
    fun turnOn() = println("Кондиционер включен")
    fun turnOff() = println("Кондиционер выключен")
    fun setTemperature(temp: Int) = println("Температура установлена на $temp°C")
}

sealed interface DeviceCommand : Command {
    data class LightOnCommand(
        val light: Light) : DeviceCommand {
        override fun execute() {
            light.turnOn()
        }
    }

    data class LightOffCommand(
        val light: Light
    ) : DeviceCommand {
        override fun execute() {
            light.turnOff()
        }
    }

    data class TVOnCommand(
        val tv: TV
    ) : DeviceCommand {
        override fun execute() {
            tv.turnOn()
        }
    }

    data class TVOffCommand(
        val tv: TV
    ) : DeviceCommand {
        override fun execute() {
            tv.turnOff()
        }
    }

    data class TVChangeChannelCommand(
        val tv: TV,
        val channel: Int
    ) : DeviceCommand {
        override fun execute() {
            tv.changeChannel(channel)
        }
    }

    data class AirConditionerOnCommand(
        val ac: AirConditioner
    ) : DeviceCommand {
        override fun execute() {
            ac.turnOn()
        }
    }

    data class AirConditionerOffCommand(
        val ac: AirConditioner
    ) : DeviceCommand {
        override fun execute() {
            ac.turnOff()
        }
    }

    data class AirConditionerSetTempCommand(
        val ac: AirConditioner,
        val temp: Int
    ) : DeviceCommand {
        override fun execute() {
            ac.setTemperature(temp)
        }
    }
}