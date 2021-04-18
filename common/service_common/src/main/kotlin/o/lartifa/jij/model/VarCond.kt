package o.lartifa.jij.model

import o.lartifa.jij.enum.Opt

/**
 * 变量条件
 *
 * Author: sinar 2021/4/18 21:03
 */
data class VarCond(
    var `var`: Var,
    var opt: Opt,
    var value: TextTemplate,
    var or: VarCond?,
    var and: VarCond?
)
