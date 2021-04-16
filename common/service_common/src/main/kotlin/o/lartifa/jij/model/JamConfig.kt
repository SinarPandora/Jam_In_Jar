package o.lartifa.jij.model

/**
 * 果酱配置
 *
 * Author: sinar
 * 2021/4/13 20:18
 */
data class JamConfig(
    val name: String,
    val qq: Long,
    val masterList: List<Long>,
    val masterCall: String = "主人",
    val autoAcceptFriendRequest: Boolean = true,
    val autoAcceptGroupRequest: Boolean = true,
    val biochronometer: Biochronometer?,
    val behaviors: List<Behavior> = emptyList()
) {
    companion object {
        data class Biochronometer(
            val wakeUpAt: Short,
            val sleepAt: Short,
            val balderdash: List<String> = emptyList()
        )
    }
}
