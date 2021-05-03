package o.lartifa.jij.util

import o.lartifa.jij.constant.ErrMsg
import o.lartifa.jij.enum.OSType

/**
 * 系统检测器
 *
 * Author: sinar 2021/4/16 22:13
 */
object OSTypeDetector {
    /** 系统类型 */
    val osType: OSType by lazy { this.osType() }

    /**
     * 获取系统类型
     *
     * @return OSType 系统类型
     */
    private fun osType(): OSType {
        val osName = System.getProperty("os.name").toLowerCase()
        return when {
            osName.contains("win") -> OSType.Windows
            osName.contains("nux") || osName.contains("nix") || osName.contains("aix") ->
                OSType.Linux
            osName.contains("mac") -> OSType.MacOS
            else -> throw IllegalArgumentException(ErrMsg.UnSupportSystem)
        }
    }
}
