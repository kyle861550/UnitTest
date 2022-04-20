import org.junit.Assert
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class StubBoy : IInfo {

    override fun isBoy(): Boolean {
        return true
    }

}

class StubGirl : IInfo {

    override fun isBoy(): Boolean {
        return false
    }

}

internal class StudentTest {

    lateinit var student : Student

    @BeforeEach
    fun setup() {
        student = Student();
    }

    @Test
    fun sayBoy() {
        Assert.assertEquals("Boy", student.say(StubBoy()))
    }

    @Test
    fun sayGirl() {
        Assert.assertEquals("Girl", student.say(StubGirl()))
    }

}