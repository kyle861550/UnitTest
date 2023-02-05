package mockk

import io.mockk.excludeRecords
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class Matcher {

    @Test
    fun testEq() {
        val clz = mockk<NormalClass>(relaxUnitFun = true)

        clz.setName("A")

        verify { clz.setName(eq("A")) }
    }

    @Test
    fun testAny() {
        val clz = mockk<NormalClass>(relaxUnitFun = true)

        clz.setName("A")

        verify { clz.setName(any()) }
    }


    @Test
    fun testExclude() {
        val clz = mockk<NormalClass>(relaxUnitFun = true)

        excludeRecords {
            clz.start()     // 排除 start
        }

        clz.setName("A")
        clz.printInfo()

        verify {
            clz.setName("A")
            clz.printInfo()

//            clz.start()       // Err. 排除後就不能使用
        }
    }

}