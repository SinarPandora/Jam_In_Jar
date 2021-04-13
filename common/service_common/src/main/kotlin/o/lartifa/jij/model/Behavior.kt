package o.lartifa.jij.model

/**
 * 行为
 *
 * Author: sinar
 * 2021/4/13 20:03
 */
data class Behavior(
    var matchers: List<Matcher>,
    var actions: List<Action>,
    var randomAct: Boolean = false,
    var alias: String?,
    var scopes: LinkedHashMap<String, List<Long>> = LinkedHashMap()
) {
    companion object {
        data class VarCond(
            var `var`: Var,
            var opt: String,
            var value: TextTemplate,
            var or: VarCond?,
            var and: VarCond?
        )

        enum class Opt(name: String) {
            EqualTo("等于"),
            DiffTo("不等于"),
            GreatThan("大于"),
            GreatOrEqual("大于等于"),
            LessThan("小于"),
            LessOrEqual("小于等于"),
        }

        data class Matcher(
            var keyword: String,
            var mode: String,
            var varCond: VarCond?
        )

        enum class Mode(ord: Int, name: String) {
            Regex(1, "满足正则"),
            StartWith(2, "以此开头"),
            EndWith(3, "以此结尾"),
            Equal(4, "完全匹配"),
            Contains(5, "包含"),
        }

        data class Action(
            var name: String,
            var params: Map<String, TextTemplate> = mapOf()
        )

        enum class Scope(ord: Int, name: String) {
            Global(1, "全局"),
            GlobalPrivate(2, "全部私聊"),
            GlobalGroup(3, "全部群聊"),
            Private(4, "指定私聊"),
            Group(5, "指定群聊"),
        }
    }
}
