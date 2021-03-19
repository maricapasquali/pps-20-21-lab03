package tasks

import u03.Lists.List._
import u03.Lists._

import scala.annotation.tailrec

object List {

  //1.a
  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (Cons(_, tail), x) if x > 0 => drop(tail, x - 1);
    case _ => l
  }

  //1.b
  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match {
    case Cons(head, tail) => append(f(head), flatMap(tail)(f))
    case Nil() => Nil()
  }

  //1.c Write map in terms of flatMap
  def mapInTermOfFlatMap[A, B](l: List[A])(mapper: A => B): List[B] = flatMap(l)(x => Cons(mapper(x), Nil()))

  //1.d Write filter in terms of flatMap
  def filterInTermOfFlatMap[A](l: List[A])(predicate: A => Boolean): List[A] =
    flatMap(l)((a: A) => a match {
      case a if predicate(a) => Cons(a, Nil())
      case _ => Nil()
    })

  // 2
  import u02.Optionals.Option
  import u02.Optionals.Option.{None, Some, getOrElse}

  def max(l: List[Int]): Option[Int] = l match {
    case Cons(head, tail) => Some(math.max(head, getOrElse(max(tail), Int.MinValue)))
    case Nil() => None()
  }

  // 3
  import u02.Modules.Person
  import u02.Modules.Person.Teacher

  def courses(people: List[Person]): List[String] =
    flatMap(people)((p: Person) => p match {
      case Teacher(_, course) => Cons(course, Nil())
      case _ => Nil()
    })

  //4 foldLeft & foldRight (Hard)
  @tailrec
  def foldLeft[A, B](l: List[A])(acc: B)(op: (B, A) => B): B = l match {
    case Cons(head, tail) => foldLeft(tail)(op(acc, head))(op)
    case Nil() => acc
  }

  def foldRight[A, B](lst: List[A])(acc: B)(op: (A, B) => B): B = {
    @tailrec
    def _foldRight(l: List[A])(a: B)(f: (A, B) => B): B = l match {
      case Cons(head, tail) => _foldRight(tail)(f(head, a))(f)
      case Nil() => a
    }

    _foldRight(reverse(lst))(acc)(op)
  }

  private def reverse[A](l: List[A]): List[A] = l match {
    case Cons(head, tail) => append(reverse(tail), Cons(head, Nil()))
    case Nil() => l
  }

}