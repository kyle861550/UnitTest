import org.junit.Assert
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito
import org.mockito.Mockito.mock

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

        Assert.assertEquals("Hello_Student", result)
    }

    @Test
    fun say_mockito() {
        val sm = StudentMock()

        val mockObj = mock(IFixString::class.java)

        Mockito.`when`(mockObj.fixString("Student")).thenReturn("Hello_Student")

        val result = sm.say(mockObj)

//        Assert.assertEquals("Hello_Apple", result)    // 失敗案例

        Assert.assertEquals("Hello_Student", result)
    }

    @Test
    fun say_mockito_2() {
        val sm = StudentMock()

        val mockObj = mock(IFixString::class.java)

        sm.say(mockObj)

        // 驗證是否有呼叫到 fixString 方法
        Mockito.verify(mockObj).fixString("Student")

    }
}