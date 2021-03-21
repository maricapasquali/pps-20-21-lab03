package tasks

import scala.annotation.tailrec
import u03.Streams.Stream
import u03.Streams.Stream._

object Stream {

  //5
  @tailrec
  def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match {
    case (s, x) if x > 0 => drop(tail(s))(x-1)
    case _ => stream
  }

  //6
  def constant[A](k : =>A): Stream[A] = cons(k, constant(k))

  //7
  val fibs: Stream[Int] = map(iterate((0, 1)) { case (x1, x2) => (x2, x1 + x2) }) { case (x1, _) => x1 }

}
