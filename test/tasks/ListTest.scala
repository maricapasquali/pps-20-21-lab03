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

  //1.c
  @Test def testMap(): Unit = {

    assertEquals(Cons(20, Cons(40, Cons(60, Nil()))), mapInTermOfFlatMap(lst)(_ * 2))

    assertEquals(Nil(), mapInTermOfFlatMap(Nil[Int]())(_ + 1))

  }

  //1.d
  @Test def testFilter(): Unit = {

    assertEquals(Cons(20, Cons(30, Nil())), filterInTermOfFlatMap(lst)(_ > 15))

    val lst1 = Cons(13, Cons(3, Cons(30, Cons(2, Cons(1, Nil())))))

    val eLst1 = Cons(13, Cons(3, Cons(2, Cons(1, Nil()))))

    assertEquals(eLst1, filterInTermOfFlatMap(lst1)(_ < 14))

  }

}
