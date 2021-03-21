package tasks

import scala.annotation.tailrec
import u03.Streams.Stream
import u03.Streams.Stream._

object Stream {

  @tailrec
  def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match {
    case (s, x) if x > 0 => drop(tail(s))(x-1)
    case _ => stream
  }

}
