package o.lartifa.jij.model

/**
 * 文本模板
 *
 * Author: sinar
 * 2021/4/13 20:01
 */
data class TextTemplate(
    val raw: String,
    val vars: List<Var> = emptyList()
)
