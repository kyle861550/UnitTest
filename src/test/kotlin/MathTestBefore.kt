import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
//import org.junit.Before
//import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class MathTestBefore {
    lateinit var math : Math

    @BeforeEach
//    @BeforeAll    // 不可使用
//    @Before       // Java & Kt 不同
    fun setup() {
        math = Math()
    }


    @Test
    fun addTest() {
        val expected = 3
        val actual = math.add(1,2)
        math.add(1,2)
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun saveAddTest() {
        val expected = 3

        math.saveAdd(1, 2)
//        Assert.assertEquals(expected, -1)     // 先寫錯誤測試
        Assert.assertEquals(expected, math.addResult)
    }

    @Test
    fun testCoverage_1() {
        val result = math.minOne(1, 2)
        Assert.assertEquals(1, result)
    }

    @Test
    fun testCoverage_2() {
        val result = math.minOne(3, 33)
        Assert.assertEquals(3, result)
    }

}