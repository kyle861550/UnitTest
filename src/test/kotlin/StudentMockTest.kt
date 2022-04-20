import org.junit.Assert
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

// 測試實作
class StudentFixString : IFixString {
    override fun fixString(str: String): String {
        return "Hello_${str}"
    }

}

internal class StudentMockTest {

    @Test
    fun say() {
        val sm = StudentMock()

        val result = sm.say(StudentFixString())

        Assert.assertEquals("Hello_Student", result);
    }
}