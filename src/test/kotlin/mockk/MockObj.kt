package mockk

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert

import org.junit.jupiter.api.Test

class MockObj {

    @Test
    fun testMock() {
        val clz1 = mockk<NormalClass>()

        every {
            clz1.getName()
        }.returns("N")

        val res = clz1.getName()

        Assert.assertEquals(res, "N")
    }

    @Test
    fun testRelaxMock() {
        val clz1 = mockk<NormalClass>(relaxed = true)       // relaxed 可以避免設定過多 `every`

        every {
            clz1.getName()
        }.returns("M")

        val res = clz1.getName()
        val res2 = clz1.getScore()                  // 預設回傳 (可以用在不重要的設定)

        println("---$res2")

        Assert.assertEquals(res, "M")

    }

    @Test
    fun testRelaxMock2() {
        val clz1 = mockk<NormalClass>(relaxUnitFun = true)       // relaxUnitFun 代表回傳值是 Unit 時生效

        every {
            clz1.getName()
        }.returns("M")

        val res = clz1.getName()
        val res2 = clz1.printInfo()

        println("---$res ---$res2")

        Assert.assertEquals(res, "M")

    }

}