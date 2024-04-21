package com.asyncapi.v2.binding.channel.ws

import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelMethod
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.schema.Type
import com.asyncapi.v3.schema.AsyncAPISchema

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class WebSocketsChannelBindingTest: SerDeTest<WebSocketsChannelBinding>() {

    override fun objectClass() = WebSocketsChannelBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/channel/ws/webSocketsChannelBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/channel/ws/webSocketsChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/channel/ws/webSocketsChannelBinding - wrongly extended.json"

    override fun build(): WebSocketsChannelBinding {
        return WebSocketsChannelBinding.builder()
                .method(WebSocketsChannelMethod.GET)
                .query(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "ref",
                                        AsyncAPISchema.builder()
                                                .type(Type.STRING)
                                                .description("Referral.")
                                                .build()
                                )
                        ))
                        .build()
                )
                .headers(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "Authentication",
                                        AsyncAPISchema.builder()
                                                .type(Type.STRING)
                                                .description("Authentication token")
                                                .build()
                                )
                        ))
                        .build()
                )
                .build()
    }

}