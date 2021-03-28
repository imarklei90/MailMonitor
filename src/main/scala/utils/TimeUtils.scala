package utils

import java.text.SimpleDateFormat
import java.util.Date
import scala.util.Random

/**
 * 时间工具类
 *
 * @author Lei
 * @date 2021/3/28
 */
object TimeUtils {

  def randomDate(startDate: String, endDate: String): Long = {

    try {
      val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
      val start: Date = dateFormat.parse(startDate)
      val end: Date = dateFormat.parse(endDate)
      if (start.getTime > end.getTime) {
        return 0L
      }

      return randomTime(start.getTime, end.getTime)
    } catch {
      case exception: Exception =>exception.printStackTrace()
    }
    return 0L
  }

  def randomTime(start: Long, end: Long): Long ={
    val returnTime: Long = start + (Math.random() * (end - start)).toLong
    if(returnTime == start || returnTime == end){
      return randomTime(start, end) / 1000
    }
    return returnTime / 1000
  }

  def main(args: Array[String]): Unit = {
    for(i <- 1 to 10){
      val date: Long = randomDate("2021-03-28", "2021-03-29")
      println(date.toLong / 1000)
      println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date))
    }

  }

}
