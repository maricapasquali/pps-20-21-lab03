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


}
