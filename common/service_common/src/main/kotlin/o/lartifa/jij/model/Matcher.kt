package o.lartifa.jij.model

import o.lartifa.jij.enum.MatchMode

/**
 * 消息捕获器
 *
 * Author: sinar 2021/4/18 21:05
 */
data class Matcher(var keyword: String, var mode: MatchMode, var varCond: VarCond?)
