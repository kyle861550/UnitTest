interface IInfo {
    fun isBoy() : Boolean
}

class Student {

    fun say(info: IInfo): String {
        val isBoy = info.isBoy()

        return if (isBoy) {
            "Boy"
        } else {
            "Girl"
        }
    }
}