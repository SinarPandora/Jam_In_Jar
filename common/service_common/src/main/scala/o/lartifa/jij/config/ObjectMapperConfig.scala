package o.lartifa.jij.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import io.quarkus.jackson.ObjectMapperCustomizer

import javax.inject.Singleton

/**
 * 自定义 Json 序列化工具
 *
 * Author: sinar
 * 2021/4/6 19:57
 */
@Singleton
class ObjectMapperConfig extends ObjectMapperCustomizer {
  override def customize(objectMapper: ObjectMapper): Unit = {
    // 注册 Scala 模块
    objectMapper.registerModule(DefaultScalaModule)
  }
}
