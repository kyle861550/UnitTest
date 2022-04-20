interface IFixString {
    fun fixString(str : String) : String
}

class StudentMock {

    fun say(fix : IFixString): String {

        var result = "Student"

        // 驗證 fixString function
        result = fix.fixString(result)  // 使用抽象

        return result
    }

}