package o.lartifa.jij.model

import o.lartifa.jij.enum.BehaviorScope

/**
 * 行为
 *
 * Author: sinar 2021/4/13 20:03
 */
data class Behavior(
    val matchers: List<Matcher>,
    val actions: List<Action>,
    val randomAct: Boolean = false,
    val alias: String?,
    val whiteList: Boolean = true,
    val scopes: LinkedHashMap<BehaviorScope, List<Long>> = LinkedHashMap()
)
