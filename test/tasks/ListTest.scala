package tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import tasks.List._
import u03.Lists.List._

class ListTest {

  private val lst = Cons(10, Cons(20, Cons(30, Nil())))

  //1.a
  @Test def testDrop(): Unit = {
    assertEquals(Cons(20, Cons(30, Nil())), drop(lst, 1))
    assertEquals(Cons(30, Nil()), drop(lst, 2))
    assertEquals(Nil(), drop(lst, 5))
  }

}
