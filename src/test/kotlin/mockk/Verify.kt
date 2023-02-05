package mockk

import io.mockk.*
import org.junit.jupiter.api.Test

class Verify {

    @Test
    fun testVerify() {
        val clz = mockk<NormalClass>()

        every { clz.start() }.just(Runs)

        clz.start()

        verify(exactly = 1) {
            clz.start()
        }
    }

    @Test
    fun testVerify2() {
        val clz = mockk<NormalClass>()

        every { clz.start() }.just(Runs)

        clz.start()

        verify(exactly = 1) {
            clz.doSomething()
        }
    }


    @Test
    fun testVerify3() {
        val clz = mockk<NormalClass>(relaxed = true)

        every { clz.start() }.just(Runs)
//        every { clz.doSomething() }.just(Runs)        // 可用 relaxed 取代

        clz.start()
        clz.doSomething()

        // 驗證順序性
        verifySequence {           // 次數也必須相同 !
            clz.start()
            clz.doSomething()
        }
    }

    @Test
    fun testVerify4() {
        val clz = mockk<NormalClass>(relaxed = true)

        every { clz.start() }.just(Runs)
//        every { clz.doSomething() }.just(Runs)        // 可用 relaxed 取代

        clz.start()
        clz.setName("123")
        clz.doSomething()

        // 驗證順序性
        verifyOrder {           // 順序相同即可
            clz.start()
            clz.doSomething()
//            clz.doSomething()     // 次數仍須相同
        }
    }

    @Test
    fun testTimeout() {
        val clz = mockk<NormalClass>(relaxed = true)

        Thread {
            Thread.sleep(300)               // 差異太小不會　timeout

            clz.start()
        }.start()

        verify(timeout = 200) {
            clz.start()
        }
    }

}