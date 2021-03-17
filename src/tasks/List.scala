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

}