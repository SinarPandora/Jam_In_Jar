package o.lartifa.jij.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import io.quarkus.jackson.ObjectMapperCustomizer
import javax.inject.Singleton

@Singleton
@Suppress("unused")
class JsonSerializationConfig : ObjectMapperCustomizer {
    override fun customize(objectMapper: ObjectMapper) {
        // To suppress serializing properties with null values
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    }
}
