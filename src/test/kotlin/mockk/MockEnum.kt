package mockk

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.Assert
import org.junit.jupiter.api.Test

class MockEnum {

    @Test
    fun testMockEnum() {
        mockkObject(Direction.E)            // 可以 mock Enum 假設它的回傳值
        every { Direction.E.code } returns 100

        Assert.assertEquals(100, Direction.E.code)
    }

}