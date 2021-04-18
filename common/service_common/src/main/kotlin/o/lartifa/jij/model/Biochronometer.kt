package o.lartifa.jij.model

/**
 * 生物钟
 *
 * Author: sinar 2021/4/18 21:12
 */
data class Biochronometer(
    val wakeUpAt: Short,
    val sleepAt: Short,
    val balderdash: List<String> = emptyList()
)
