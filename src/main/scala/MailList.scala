/**
 *
 * @author Lei
 * @date 2021/3/26
 */
case class MailList(
                     fromAddr: String,
                      fromIp: String,
                      toPath: String,
                      toAddr: String,
                      toIp: String,
                      title: String,
                      content: String,
                      addTime: Long,
                      file: String,
                      saveFlag: Int,
                      outFlag: Int,
                      bz: String,
                     language: String
                   )
