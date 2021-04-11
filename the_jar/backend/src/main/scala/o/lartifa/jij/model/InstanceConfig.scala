package o.lartifa.jij.model

import o.lartifa.jij.model.InstanceConfig.Ports
import org.mongodb.scala.bson.ObjectId

import java.sql.Timestamp

/**
 * 实例配置
 *
 * Author: sinar
 * 2021/4/10 21:23
 */
case class InstanceConfig
(
  _id: ObjectId,
  userId: ObjectId,
  ports: Ports,
  launchTime: Timestamp,
  statusName: String,
  version: String,
  jamConfig: JamConfig
)

object InstanceConfig {
  /**
   * 端口组（修改需要重启实例）
   *
   * @param toMirai   上报端口（Jam -> Mirai）
   * @param fromMirai 监听端口（Mirai -> Jam）
   */
  case class Ports(toMirai: Int, fromMirai: Int)

  object Statuses extends Enumeration {
    type Status = Value
    val Creating: this.Value = Value("正在创建")
    val Starting: this.Value = Value("正在启动")
    val Running: this.Value = Value("运行中")
    val Stopping: this.Value = Value("正在停止")
    val Stopped: this.Value = Value("已停止")
    val Terminated: this.Value = Value("已销毁")
  }
}
