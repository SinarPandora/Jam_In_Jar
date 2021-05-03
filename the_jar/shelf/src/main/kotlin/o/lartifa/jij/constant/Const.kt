package o.lartifa.jij.constant

/**
 * 常量
 *
 * Author: sinar
 * 2021/4/19 21:50
 */
object Const {
    /**
     * 验证相关
     */
    object Auth {
        const val BcryptCost: Int = 10
        const val UID: String = "uid"
    }

    /**
     * 字段相关
     */
    object Field {
        object User {
            const val Name: String = "name"
        }
    }
}
