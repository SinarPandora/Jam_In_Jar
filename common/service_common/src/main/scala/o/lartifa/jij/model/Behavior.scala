package o.lartifa.jij.model

import o.lartifa.jij.model.Behavior.{Action, Matcher}

import scala.collection.immutable.ListMap

/**
 * 果酱行为
 *
 * Author: sinar
 * 2021/4/10 23:34
 */
case class Behavior
(
  matchers: List[Matcher],
  actions: List[Action],
  randomChooseAction: Boolean = false,
  alias: Option[String] = None,
  scopes: ListMap[String, List[Long]] = ListMap.empty
)

object Behavior {
  /**
   * 变量条件
   *
   * @param $var    变量
   * @param optName 操作符
   * @param value   目标值（模板）
   * @param or      或条件（可选）
   * @param and     与条件（可选）
   */
  case class VarCondition($var: Var, optName: String, value: TextTemplate,
                          or: Option[VarCondition] = None, and: Option[VarCondition] = None)

  object Opts extends Enumeration {
    type Opt = Value

    val EqualTo: this.Value = Value("等于")
    val DiffTo: this.Value = Value("不等于")
    val GreatThan: this.Value = Value("大于")
    val GreatOrEqual: this.Value = Value("大于等于")
    val LessThan: this.Value = Value("小于")
    val LessOrEqual: this.Value = Value("小于等于")
  }

  /**
   * 捕获器
   *
   * @param keyword  关键词
   * @param modeName 捕获模式
   * @param varCond  变量条件
   */
  case class Matcher(keyword: String, modeName: String, varCond: VarCondition)

  object Modes extends Enumeration {
    type Mode = Value

    val Regex: this.Value = Value(1, "满足正则")
    val StartWith: this.Value = Value(2, "以此开头")
    val EndWith: this.Value = Value(3, "以此结尾")
    val Equal: this.Value = Value(4, "完全匹配")
    val Contains: this.Value = Value(5, "包含")
  }

  /**
   * 行动
   *
   * @param name   名称
   * @param params 参数
   */
  case class Action(name: String, params: Map[String, TextTemplate])

  object Scopes extends Enumeration {
    type Scope = Value

    val Global: this.Value = Value(1, "全局")
    val GlobalPrivate: this.Value = Value(2, "全部私聊")
    val GlobalGroup: this.Value = Value(3, "全部群聊")
    val Private: this.Value = Value(4, "指定私聊")
    val Group: this.Value = Value(5, "指定群聊")
  }
}
