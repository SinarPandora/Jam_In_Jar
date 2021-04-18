package o.lartifa.jij.enum

/**
 * 消息捕获模式
 *
 * Author: sinar 2021/4/18 21:06
 */
enum class MatchMode(name: String) {
    Regex("满足正则"),
    StartWith("以此开头"),
    EndWith("以此结尾"),
    Equal("完全匹配"),
    Contains("包含"),
}
