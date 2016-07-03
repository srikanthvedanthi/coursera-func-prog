package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c > r) throw new IllegalArgumentException()
    if (c == r || c == 0) 1 else fact(1, r) / (fact(1, c) * fact(1, r - c))
  }

  def fact(accu: Int, num: Int): Int = {
    if (num == 1) accu else fact(num * accu, num - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    checkParen(0, chars) == 0
  }

  def checkParen(count: Int, chars: List[Char]): Int = {
    if (count < 0) count
    else if (chars.isEmpty) count
    else if (chars.head.equals('('))
      checkParen(count + 1, chars.tail)
    else if (chars.head.equals(')'))
      checkParen(count - 1, chars.tail)
    else
      checkParen(count, chars.tail)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    allCombi(money, coins, 0)
  }

  def allCombi(money: Int, coins: List[Int], count: Int): Int = {
    if (money < 0) 0
    else if (money == 0) 1
    else if (count == coins.size && money > 0) 0
    else allCombi(money - coins(count), coins, count) + allCombi(money, coins, count + 1)
  }
}
