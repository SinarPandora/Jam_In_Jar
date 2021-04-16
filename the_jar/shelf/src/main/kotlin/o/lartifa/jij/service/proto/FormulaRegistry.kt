package o.lartifa.jij.service.proto

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import o.lartifa.jij.model.Formula

/**
 * 配方库
 *
 * Author: sinar
 * 2021/4/15 00:11
 */
interface FormulaRegistry {
    /**
     * 列出全部配方
     * <建议实现缓存>
     *
     * @return 全部配方
     */
    fun listAll(): Multi<Formula>

    /**
     * 添加配方
     *
     * @param formula 配方
     * @return 操作结果
     */
    fun add(formula: Formula): Uni<Unit>

    /**
     * 删除配方
     *
     * @param id 配方 ID
     * @return 操作结果
     */
    fun remove(id: String): Uni<Unit>

    /**
     * 更新配方
     *
     * @param formula 配方
     * @return 操作结果
     */
    fun update(formula: Formula): Uni<Unit>
}
