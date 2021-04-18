package o.lartifa.jij.model

/**
 * 行为
 *
 * Author: sinar 2021/4/18 21:07
 */
data class Action(var name: String, var params: Map<String, TextTemplate> = mapOf())
