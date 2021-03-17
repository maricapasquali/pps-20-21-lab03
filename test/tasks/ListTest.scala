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

  //2
  import u02.Optionals.Option.{None, Some};

  @Test def testMax(): Unit = {
    assertEquals(None(), max(Nil()))

    assertEquals(Some(30), max(lst))

    assertEquals(Some(25), max(Cons(10, Cons(25, Cons(20, Nil())))))

    assertEquals(Some(-1), max(Cons(-10, Cons(-1, Cons(-20, Nil())))))

    assertEquals(Some(10), max(Cons(10, Cons(-1, Cons(-20, Nil())))))

    assertEquals(Some(10), max(Cons(10, Nil())))

    assertEquals(Some(-20), max(Cons(-20, Nil())))
  }

  // 3
  import u02.Modules.Person
  import u02.Modules.Person.{Student, Teacher}

  @Test def testCourses(): Unit = {
    val c1 = "applicazioni e servizi web"
    val c2 = "machine learning"
    val c3 = "sistemi distribuiti"

    val t1: Person = Teacher("anna verdi", c1)
    val t2: Person = Teacher("carlo bianchi", c2)
    val t3: Person = Teacher("mario rossi", c3)

    val s1: Person = Student("mario rossi", 2017)
    val s2: Person = Student("giacomo rossi", 2015)
    val s3: Person = Student("giada bianchi", 2017)

    val p1 = Cons(t1, Cons(s1, Cons(t2, Cons(t3, Nil()))))

    val p2 = Cons(s1, Cons(s2, Cons(s3, Nil())))

    assertEquals(Cons(c1, Cons(c2, Cons(c3, Nil()))), courses(p1))

    assertEquals(Nil(), courses(Nil()))

    assertEquals(Nil(), courses(p2))

  }


}
