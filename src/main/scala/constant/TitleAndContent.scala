package constant

import scala.collection.mutable
import scala.collection.mutable.HashMap
import scala.util.Random

/**
 * 邮件标题和内容
 *
 * @author Lei
 * @date 2021/3/28
 */
object TitleAndContent {
  def getData(): HashMap[String, String] = {
    val dataMap = new HashMap[String, String]()

    dataMap.put("来聊聊：科技公司应该留住35岁员工吗？", "在IT互联网行业，年龄焦虑已是老生常谈，过了35岁非高管则劝退仿佛成了常规操作。但实际上，高龄程序员在不少硅谷IT公司是普遍现象，我们常用的手机、pc系统也是这群程序员们的成果。偏爱年轻员工是企业利益机制决定的，但一味标榜公司年轻化，会不会是一种发展误区和短视的做法呢？来，咱们聊聊科技公司「应该」留住年长员工的理由～")
    dataMap.put("支付宝提醒", "亲爱的会员：您好！您在支付宝操作身份校验时提交的证件已审核通过。")
    dataMap.put("You've been invited to join \uD83C\uDF81ПОЗДРАВЛЯЕМ ВАС on Spacetime", "You’ve been invited!\nThis is an automatically generated message notifying you that you have received a special VIP invitation from one of your colleagues or friends.")
    dataMap.put("<广告> 健康新起点，换购 Apple Watch 仅 RMB 96/月起*", "Apple Watch 哪里好健康生活的好拍档，非它莫属。有了这个健身好伙伴，你可以了解关于自己的健康信息,并与关心的人保持联络，重要的事也不错过。")
    dataMap.put("Re: 实时数据平台 - Confluent Platform", "能不能描述一下，你们目前是如何使用Apache Kafka？")
    dataMap.put("京东商品到货通知", "您所关注的 商品已经到货！此时，共有 9 位用户与您一同抢购！下手要快哦！")
    dataMap.put("Bill Gates分享了动态: Private sector...", "\nBill Gates分享了动态: Private sector leadership is essential to fostering innovation and getting green ideas to market. Greentown Labs was an important partner in the development of Breakthrough Energy 's Corporate Climate Action Playbook.")
    dataMap.put("Gitee | Gitee 邮箱绑定通知", "你的 Gitee 帐号已成功绑定邮箱,如非本人操作，请及时检查帐号邮箱绑定并修改密码。")
    dataMap.put("【邀请函】HUAWEI Developer Day · 上海站 · 沙龙(AD)", "HDD·上海站·沙龙”将于3月31日在“上海中星铂尔曼大酒店”举行，点击链接报名https://url.cloud.huawei.com/bdPvKYkMzC,如图片未显示可点击左上角下载")
    dataMap.put("安全提醒", "有人刚刚在一台新 Windows 设备上登录了您的 Google 帐号。因此，我们向您发送这封电子邮件，以确保该操作是您本人所为。")

    dataMap.put("微信公众号已正常使用", "你好，以上帐号已在指定时间内登录，此帐号可继续正常使用，请珍惜微信公众平台帐号资源，切勿浪费。")
    dataMap.put("YouTube 的《服务条款》有变化", "我们将要更新我们的服务条款（简称“条款”），以提升条款的可读性和透明度。本次更新不会改变 Google 隐私权政策，也不会改变我们收集和处理您数据的方式。")
    dataMap.put("检查 Google 帐号的安全状态", "利用新的“安全检查”工具确保您更加安全地上网,您的“安全检查”工具该升级了。升级后的“安全检查”工具可以为您提供具体、更个性化的建议，以增强您的 Google 帐号的安全性。")
    dataMap.put("国庆、中秋放假通知", "国庆、中秋放假时间已经确定，请大家查询附件，提前做好工作及出行安排，预祝节日快乐！")
    dataMap.put("腾讯企业邮新功能介绍", "腾讯企业邮新版本已发布，内容如下：1. 写信自动联想优化:成员使用网页版邮箱写信时，自动联想列表支持展示同事部门、个人或公共联系人的公司和部门信息。2. 成员可见业务邮箱:成员如果拥有通讯录权限，即可在网页版的 “通讯录-业务邮箱” 下看到企业内的所有业务邮箱。")

    dataMap

  }

  def getTitleAndContent(): (String, String)= {
    import scala.collection.JavaConverters._
    var title: String = ""
    var content: String = ""

    val dataMap: mutable.HashMap[String, String] = getData()
    val randomIndex: Int = new Random().nextInt(dataMap.size)

    title = dataMap.keys.toList.asJava.get(randomIndex)
    content = dataMap(title)

    (title, content)
  }

  def main(args: Array[String]): Unit = {
    import scala.collection.JavaConverters._
    val dataMap: mutable.HashMap[String, String] = getData()
    val randomIndex: Int = new Random().nextInt(dataMap.size)

    println(dataMap.keys.toList.asJava.get(randomIndex), dataMap(dataMap.keys.toList.asJava.get(randomIndex)))





//
//    val random = new Random()
//    val mapSize: Int = dataMap.keys
//    dataMap.keys.toArray()

  }

}
