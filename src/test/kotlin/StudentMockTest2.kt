import org.junit.Assert
import org.junit.Before
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

internal class StudentMockTest2 {

    @Mock
    lateinit var mockObj : IFixString

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun say_mockito() {
        val sm = StudentMock()

        Mockito.`when`(mockObj.fixString("Student")).thenReturn("Hello_Student")

        val result = sm.say(mockObj)

//        Assert.assertEquals("Hello_Apple", result)    // 失敗案例

        Assert.assertEquals("Hello_Student", result)
    }

    @Test
    fun say_mockito_2() {
        val sm = StudentMock()

        sm.say(mockObj)

        // 驗證是否有呼叫到 fixString 方法
        Mockito.verify(mockObj).fixString("Student")

    }
}