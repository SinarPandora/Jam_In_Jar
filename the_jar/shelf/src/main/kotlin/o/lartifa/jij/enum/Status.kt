package o.lartifa.jij.enum

/**
 * 果酱罐状态
 *
 * Author: sinar
 * 2021/4/18 21:14
 */
enum class Status(name: String) {
    NotInit("未初始化"),
    Creating("正在创建"),
    Starting("正在启动"),
    Running("运行中"),
    Stopping("正在停止"),
    Stopped("已停止"),
    Terminated("已销毁"),
}
