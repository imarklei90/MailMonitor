import constant.TitleAndContent
import utils.{IpUtils, TimeUtils}

import java.io.{File, InputStreamReader, PrintWriter}
import java.nio.charset.StandardCharsets
import java.util.Properties
import scala.util.Random

/**
 *
 * @author Lei
 * @date 2021/3/26
 */
object GenerateMailData {

  def load(propertiesName: String): Properties= {

    val props = new Properties()

    // 加载配置文件
    props.load(new InputStreamReader(Thread.currentThread().getContextClassLoader
      .getResourceAsStream(propertiesName), StandardCharsets.UTF_8))

    props

  }

  def main(args: Array[String]): Unit = {
    val properties = load("config.properties")

    import scala.collection.JavaConverters._

    val fromNameList: java.util.List[String] = properties.getProperty("fromName").split(",").toList.asJava
    val fromAddrList: java.util.List[String] = properties.getProperty("fromAddr").split(",").toList.asJava
    val fromIpList: java.util.List[String] = properties.getProperty("fromIp").split(",").toList.asJava
    val toPathList: java.util.List[String] = properties.getProperty("toPath").split(",").toList.asJava
    val toAddrList: java.util.List[String] = properties.getProperty("toAddr").split(",").toList.asJava
    val addTimeList: java.util.List[String] = properties.getProperty("addTime").split(",").toList.asJava

    val titleList: java.util.List[String] = properties.getProperty("title").split(",").toList.asJava
    val languageList: java.util.List[String] = properties.getProperty("language").split(",").toList.asJava

    // 创建输出流
    val writer = new PrintWriter(new File("data/data.sql"))

    for(i <- 1 to 5000) {

      val fromName: String = fromNameList.get(new Random().nextInt(fromNameList.size()))
      val fromAddr: String = fromAddrList.get(new Random().nextInt(fromAddrList.size()))
      val fromIp: String = IpUtils.getRandomIp //.get(new Random().nextInt(fromIpList.size()))

      val toPath: String = toPathList.get(new Random().nextInt(toPathList.size()))
      val toAddr: String = toAddrList.get(new Random().nextInt(toAddrList.size())) // properties.getProperty("toAddr")
      val toIp: String = IpUtils.getRandomIp //properties.getProperty("toIp")

      val addTime: String = TimeUtils.randomDate("2019-01-01", "2021-03-28").toString //addTimeList.get(new Random().nextInt(addTimeList.size()))
      val file: String = properties.getProperty("file")
      val saveFlag: String = properties.getProperty("saveFlag")
      val outFlag: String = properties.getProperty("outFlag")
      val bz: String = properties.getProperty("bz")
      val language: String = languageList.get(new Random().nextInt(languageList.size() - 1))

      val (title, content): (String, String) = TitleAndContent.getTitleAndContent()
      val sql = s"INSERT INTO jdmail.mail_list values($i, '${fromName}','${fromName}${fromAddr}','${fromIp}','${toPath}','${toPath}${toAddr}','${toIp}','${title}','${content}','${addTime}','${file}','${saveFlag}','${outFlag}','${bz}', '${language}');"
      println(sql)
      // 添加到输出流
      writer.append(sql + "\n")
    }

    writer.close()
  }

}
