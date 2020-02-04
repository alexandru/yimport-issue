package example

import scala.util.Try

object Hello {
  def main(args: Array[String]): Unit = {
    // Uncomment this for syntax to work in IntelliJ IDEA:
    // import cats.implicits._

    val sum = for {
      arg1 <- args.headOption.toRight("Missing arg1")
      num1 <- Try(arg1.toInt).toEither
      // Syntax from Cats, not seen in IntelliJ...
      num2 <- 10.pure[({type L[A] = Either[String, A]})#L]
    } yield {
      num1 + num2
    }

    val r = sum
      // Syntax from Cats, not seen in IntelliJ...
      .leftMap(x => s"Error: $x")
      .fold(e => throw new RuntimeException(e), identity)

    println(r)
  }
}
