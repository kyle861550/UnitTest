package mockk

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.jupiter.api.Test

class MockVararg {

    @Test
    fun testMockVararg_varargAllInt() {
        val mock = mockk<VarargClz>()

        // varargAllInt 代表固定的數值，但該數值可以多個
        every { mock.doMany(1, 2, *varargAllInt { it == 5 }) }.returns(999)

        val res = mock.doMany(1, 2, 5, 5, 5)        // 多個 5
//        val res = mock.doMany(1, 2, 2, 5, 5)              // Err: 前面必須是 1, 2, 5 x N

        Assert.assertEquals(999, res)
    }

    @Test
    fun testMockVararg_anyIntVararg() {
        val mock = mockk<VarargClz>()

        // anyIntVararg 任意數字
        every { mock.doMany(1, 2, *anyIntVararg(), 5) }.returns(999)

        val res = mock.doMany(1, 2, 5, 5, 5)        // 多個 5
        Assert.assertEquals(999, res)

        val res2 = mock.doMany(1, 2, 2, 5)              // 前面必須是 1, 2, 最後 5
        Assert.assertEquals(999, res2)

//        val res3 = mock.doMany(1, 2, 2, 4)        // Err: 最後不是 5
//        Assert.assertEquals(999, res3)
    }

}