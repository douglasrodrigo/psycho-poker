package poker

import poker.model._
import java.io.FileReader

object PsychoPoker extends App {
  Parser.apply(new FileReader(args.head)).foreach(println(_))
}
