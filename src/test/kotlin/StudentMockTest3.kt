import org.junit.Assert
import org.junit.Before
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

internal class StudentMockTest3 {

    @Mock
    lateinit var mockObj : IFixString

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun say_mockito_call_method_times() {
        val sm = StudentMock()

        sm.say(mockObj)

        // 驗證是否有呼叫到 fixString 方法
        Mockito.verify(mockObj).fixString("Student")

        Mockito.verify(mockObj, Mockito.never()).fixString("Apple")

        Mockito.verify(mockObj, Mockito.times(1)).fixString("Student")
//        Mockito.verify(mockObj, Mockito.times(2)).fixString("Student")    // 錯誤測試

        Mockito.verify(mockObj, Mockito.atLeast(1)).fixString("Student")

        Mockito.verify(mockObj, Mockito.atMost(1)).fixString("Student")

//        Mockito.verify(mockObj).fixString(Mockito.any())    // 只要有被呼叫即可，不關心傳入參數       // any 異常 ???

    }
}