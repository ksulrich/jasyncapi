package com.asyncapi.schemas.json.properties

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.schemas.SchemaProvider
import java.math.BigInteger

class ConstDefaultExamplesBigIntegerMaximumTest: SchemaProvider {

    private val value = BigInteger("214748364721474836472147483647")

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