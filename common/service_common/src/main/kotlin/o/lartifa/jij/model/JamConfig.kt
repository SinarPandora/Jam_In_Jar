package o.lartifa.jij.model

/**
 * 果酱配置
 *
 * Author: sinar
 * 2021/4/13 20:18
 */
data class JamConfig(
    var name: String,
    var qq: Long,
    var masterList: List<Long>,
    var masterCall: String = "主人",
    var autoAcceptFriendRequest: Boolean = true,
    var autoAcceptGroupRequest: Boolean = true,
    var biochronometer: Biochronometer?,
    var behaviors: List<Behavior> = emptyList()
) {
    companion object {
        data class Biochronometer(
            val wakeUpAt: Short,
            val sleepAt: Short,
            val balderdash: List<String> = emptyList()
        )
    }
}
