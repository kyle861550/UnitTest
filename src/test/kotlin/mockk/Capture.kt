package mockk

import io.mockk.*
import org.junit.Assert
import org.junit.jupiter.api.Test

class Capture {

    @Test
    fun testCapture() {
        val clz = mockk<NormalClass>()

        val slot = slot<String>()

        every { clz.setName(capture(slot)) }.just(Runs)

        clz.setName("Apple")        // 擷取這個 Apple 參數

        Assert.assertEquals("Apple", slot.captured)         // 判斷設定的參數是否是 Apple
    }

}