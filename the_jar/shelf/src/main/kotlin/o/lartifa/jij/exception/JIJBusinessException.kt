package o.lartifa.jij.exception

/**
 * 罐装果酱业务逻辑异常
 *
 * Author: sinar
 * 2021/4/19 01:56
 */
class JIJBusinessException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)
