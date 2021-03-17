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

  //1.b
  @Test def testFlatMap(): Unit = {

    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))),
      flatMap(lst)(v => Cons(v + 1, Nil())))

    assertEquals(Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil())))))),
      flatMap(lst)(v => Cons(v + 1, Cons(v + 2, Nil()))))

  }

}
