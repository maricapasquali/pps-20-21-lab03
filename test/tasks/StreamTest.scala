package tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import tasks.Stream._
import u03.Lists.List._

import u03.Streams.Stream._;

class StreamTest {

  //5
  @Test def testDrop(): Unit = {
    val s = take(iterate(0)(_+1))(10)
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))),
                 toList(drop(s)(6)))

    assertEquals(Nil(), toList(drop(empty())(6)))
  }

  //6
  @Test def testConstant(): Unit = {
    val k = "x";
    val lst = Cons(k, Cons(k, Cons(k, Cons(k, Cons(k, Nil())))))
    assertEquals(lst, toList(take(constant(k))(5)))

    val x = 3;
    val lst1 = Cons(x, Cons(x, Cons(x, Nil())))
    assertEquals(lst1, toList(take(constant(x))(3)))
  }

}
