package com.asyncapi.v3.schema.json.properties

import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.SchemaProvider

class ConstDefaultExamplesIntTest: SchemaProvider {

    private val value: Int = 0


    override fun jsonSchema(): JsonSchema {
        return JsonSchema.builder()
                .constValue(value)
                .defaultValue(value)
                .examples(listOf(value))
                .build()
    }

    override fun asyncAPISchema(): AsyncAPISchema {
        return AsyncAPISchema.builder()
                .constValue(value)
                .defaultValue(value)
                .examples(listOf(value))
                .build()
    }

}