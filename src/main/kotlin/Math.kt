class Math {
    var addResult = 0

    fun add(n1: Int, n2: Int) : Int {
        return n1 + n2
    }

    fun saveAdd(n1: Int, n2: Int) {
        addResult = n1 + n2
    }

    fun minOne(n1: Int, n2: Int) : Int {
        if(n1 > n2) {
            return n2
        }
        return n1
    }
}