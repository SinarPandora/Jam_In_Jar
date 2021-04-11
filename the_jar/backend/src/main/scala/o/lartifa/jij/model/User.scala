package o.lartifa.jij.model

import org.mongodb.scala.bson.ObjectId

/**
 * 用户
 *
 * Author: sinar
 * 2021/4/10 21:22
 */
case class User
(
  _id: ObjectId,
  name: String,
  passHash: String,
  roleName: String = "果酱监护人",
  info: String = "",
)

object User {
  object Roles extends Enumeration {
    type Role = Value

    val JamParent: this.Value = Value("果酱监护人")
    val JarAdmin: this.Value = Value("果酱罐管理人")
  }
}
