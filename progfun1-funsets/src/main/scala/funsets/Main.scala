package funsets

object Main extends App {
  import FunSets._

  private val set1: Set = singletonSet(1)
  println(contains(set1, 1))
  println(union(set1, singletonSet(2)))
}
