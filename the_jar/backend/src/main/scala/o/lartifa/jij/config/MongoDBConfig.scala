package o.lartifa.jij.config

import o.lartifa.jij.model.JamConfig
import o.lartifa.jij.model.{InstanceConfig, JamVersion, User}
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.mongodb.scala.{MongoClient, MongoDatabase}

import javax.inject.Singleton

/**
 * MongoDB 配置
 *
 * Author: sinar
 * 2021/4/10 21:47
 */
class MongoDBConfig(@ConfigProperty(name = "jar.mongodb_url", defaultValue = "mongodb://localhost:27017") val mongoDBUrl: String) {
  /**
   * MongoDB client
   *
   * @return Client
   */
  @Singleton
  def mongoDBClient(): MongoDatabase = {
    MongoClient(uri = mongoDBUrl).getDatabase("jij")
      .withCodecRegistry(fromRegistries(fromProviders(
        classOf[JamConfig],
        classOf[InstanceConfig],
        classOf[User],
        classOf[JamVersion]
      ), DEFAULT_CODEC_REGISTRY))
  }

}
