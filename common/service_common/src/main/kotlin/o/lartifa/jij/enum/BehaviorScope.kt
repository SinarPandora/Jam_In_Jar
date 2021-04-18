package o.lartifa.jij.enum

/**
 * 行为范围
 *
 * Author: sinar 2021/4/18 21:08
 */
enum class BehaviorScope(name: String) {
    Global("全局"),
    GlobalPrivate("全部私聊"),
    GlobalGroup("全部群聊"),
    Private("指定私聊"),
    Group("指定群聊"),
}
