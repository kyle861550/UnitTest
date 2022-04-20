import org.junit.Assert
//import org.junit.Test // 失敗
import org.junit.jupiter.api.Test

class MathTest {
    @Test
    fun addTest() {
        val expected = 3
        val actual = Math().add(1,2)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun saveAddTest() {
        val expected = 3

        val math = Math()
        math.saveAdd(1, 2)

//        Assert.assertEquals(expected, -1)     // 先寫錯誤測試
        Assert.assertEquals(expected, math.addResult)
    }

    @Test
    fun testCoverage_1() {
        val math = Math()

        val result = math.minOne(1, 2)
        Assert.assertEquals(1, result)
    }

    @Test
    fun testCoverage_2() {
        val math = Math()

        val result = math.minOne(3, 33)
        Assert.assertEquals(3, result)
    }
}