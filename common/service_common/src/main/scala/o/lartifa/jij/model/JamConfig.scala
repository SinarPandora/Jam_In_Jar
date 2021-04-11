package o.lartifa.jij.model

import o.lartifa.jij.model.JamConfig.Biochronometer

/**
 * 果酱配置
 *
 * Author: sinar
 * 2021/4/10 21:32
 */
case class JamConfig
(
  name: String,
  qq: Long,
  masters: List[Long],
  masterCall: String = "主人",
  autoAcceptFriendRequest: Boolean = true,
  autoAcceptGroupRequest: Boolean = true,
  biochronometer: Option[Biochronometer] = None,
  behaviors: List[Behavior] = Nil
)

object JamConfig {
  case class Biochronometer(wakeUpAt: Short, sleepAt: Short, balderdash: List[String] = Nil)
}
