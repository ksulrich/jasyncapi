package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.Reference
import com.asyncapi.v3._0_0.model.ExternalDocumentation
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.Parameter
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.channel.message.MessageExample
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.info.Contact
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding
import com.asyncapi.v3.schema.AsyncAPISchema
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WebsocketGeminiAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/websocket-gemini-asyncapi.yml"

    override fun expectedInfo(): Info {
        return Info(
                "Gemini Market Data Websocket API",
                "1.0.0",
                """
                Market data is a public API that streams all the market data on a given symbol.

                You can quickly play with the API using [websocat](https://github.com/vi/websocat#installation) like this:
                ```bash
                websocat wss://api.gemini.com/v1/marketdata/btcusd?heartbeat=true -S
                ```

                """.trimIndent(),
                null,
                Contact("Gemini", "https://www.gemini.com/", null),
                null,
                null,
                ExternalDocumentation(null, "https://docs.sandbox.gemini.com/websocket-api/#market-data")
        )
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(Pair("public", Server.builder().host("api.gemini.com").protocol("wss").build()))
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("marketDataV1",
                        Channel.builder()
                                .address("/v1/marketdata/{symbol}")
                                .messages(
                                        mapOf(
                                                Pair("marketData", Reference("#/components/messages/marketData"))
                                        )
                                )
                                .parameters(
                                        mapOf(
                                                Pair(
                                                        "symbol",
                                                        Parameter.builder()
                                                                .enumValues(listOf(
                                                                        "btcusd",
                                                                        "ethbtc",
                                                                        "ethusd",
                                                                        "zecusd",
                                                                        "zecbtc",
                                                                        "zeceth",
                                                                        "zecbch",
                                                                        "zecltc",
                                                                        "bchusd",
                                                                        "bchbtc",
                                                                        "bcheth",
                                                                        "ltcusd",
                                                                        "ltcbtc",
                                                                        "ltceth",
                                                                        "ltcbch",
                                                                        "batusd",
                                                                        "daiusd",
                                                                        "linkusd",
                                                                        "oxtusd",
                                                                        "batbtc",
                                                                        "linkbtc",
                                                                        "oxtbtc",
                                                                        "bateth",
                                                                        "linketh",
                                                                        "oxteth",
                                                                        "ampusd",
                                                                        "compusd",
                                                                        "paxgusd",
                                                                        "mkrusd",
                                                                        "zrxusd",
                                                                        "kncusd",
                                                                        "manausd",
                                                                        "storjusd",
                                                                        "snxusd",
                                                                        "crvusd",
                                                                        "balusd",
                                                                        "uniusd",
                                                                        "renusd",
                                                                        "umausd",
                                                                        "yfiusd",
                                                                        "btcdai",
                                                                        "ethdai",
                                                                        "aaveusd",
                                                                        "filusd",
                                                                        "btceur",
                                                                        "btcgbp",
                                                                        "etheur",
                                                                        "ethgbp",
                                                                        "btcsgd",
                                                                        "ethsgd",
                                                                        "sklusd",
                                                                        "grtusd",
                                                                        "bntusd",
                                                                        "1inchusd",
                                                                        "enjusd",
                                                                        "lrcusd",
                                                                        "sandusd",
                                                                        "cubeusd",
                                                                        "lptusd",
                                                                        "bondusd",
                                                                        "maticusd",
                                                                        "injusd",
                                                                        "sushiusd"
                                                                ))
                                                                .description(
                                                                        "Symbols are formatted as CCY1CCY2 where prices are in CCY2 and quantities are in CCY1. To read more click [here](https://docs.sandbox.gemini.com/websocket-api/#symbols-and-minimums).\n"
                                                                )
                                                                .build()
                                                )
                                        )
                                )
                                .bindings(
                                        mapOf(
                                                Pair(
                                                        "ws",
                                                        WebSocketsChannelBinding.builder()
                                                                .query(
                                                                        AsyncAPISchema.builder()
                                                                                .type("object")
                                                                                .description(
                                                                                        "The semantics of entry type filtering is:\n" +
                                                                                        "\n" +
                                                                                        "If any entry type is specified as true or false, all of them must be explicitly flagged true to show up in the response\n" +
                                                                                        "If no entry types filtering parameters are included in the url, then all entry types will appear in the response\n" +
                                                                                        "\n" +
                                                                                        "NOTE: top_of_book has no meaning and initial book events are empty when only trades is specified\n"
                                                                                )
                                                                                .properties(mapOf(
                                                                                        Pair(
                                                                                                "heartbeat",
                                                                                                AsyncAPISchema.builder()
                                                                                                        .type("boolean")
                                                                                                        .defaultValue(false)
                                                                                                        .description(
                                                                                                                "Optionally add this parameter and set to true to receive a " +
                                                                                                                "heartbeat every 5 seconds"
                                                                                                        )
                                                                                                        .build()
                                                                                        ),
                                                                                        Pair(
                                                                                                "top_of_book",
                                                                                                AsyncAPISchema.builder()
                                                                                                        .type("boolean")
                                                                                                        .defaultValue(false)
                                                                                                        .description(
                                                                                                                "If absent or false, receive full order book depth; if present " +
                                                                                                                "and true, receive top of book only. Only applies to bids and " +
                                                                                                                "offers."
                                                                                                        )
                                                                                                        .build()
                                                                                        ),
                                                                                        Pair(
                                                                                                "bids",
                                                                                                AsyncAPISchema.builder()
                                                                                                        .type("boolean")
                                                                                                        .defaultValue(true)
                                                                                                        .description("Include bids in change events")
                                                                                                        .build()
                                                                                        ),
                                                                                        Pair(
                                                                                                "offers",
                                                                                                AsyncAPISchema.builder()
                                                                                                        .type("boolean")
                                                                                                        .defaultValue(true)
                                                                                                        .description("Include asks in change events")
                                                                                                        .build()
                                                                                        ),
                                                                                        Pair(
                                                                                                "trades",
                                                                                                AsyncAPISchema.builder()
                                                                                                        .type("boolean")
                                                                                                        .defaultValue(true)
                                                                                                        .description("Include trade events")
                                                                                                        .build()
                                                                                        ),
                                                                                        Pair(
                                                                                                "auctions",
                                                                                                AsyncAPISchema.builder()
                                                                                                        .type("boolean")
                                                                                                        .defaultValue(true)
                                                                                                        .description("Include auction events")
                                                                                                        .build()
                                                                                        )
                                                                                ))
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                        )
                                )
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(Pair(
                "sendMarketData",
                Operation.builder()
                        .action(OperationAction.SEND)
                        .channel(Reference("#/channels/marketDataV1"))
                        .summary("Receive market updates on a given symbol")
                        .messages(
                                listOf(Reference("#/channels/marketDataV1/messages/marketData"))
                        )
                        .build()
        ))
    }

    override fun expectedComponents(): Components {
        return Components.builder()
                .messages(mapOf(
                        Pair(
                                "marketData",
                                Message.builder()
                                        .summary("Message with marked data information.")
                                        .description(
                                                "The initial response message will show the existing state of the order " +
                                                "book. Subsequent messages will show all executed trades, as well as all " +
                                                "other changes to the order book from orders placed or canceled.\n"
                                        )
                                        .payload(Reference("#/components/schemas/market"))
                                        .examples(listOf(
                                                MessageExample.builder()
                                                        .name("updateMessage")
                                                        .summary("Example of an update message that contains a change in price information.")
                                                        .payload(mapOf(
                                                                Pair("type", "update"),
                                                                Pair("eventId", 36902233362),
                                                                Pair("timestamp", 1619769673),
                                                                Pair("timestampms", 1619769673527),
                                                                Pair("socket_sequence", 661),
                                                                Pair("events", listOf(mapOf(
                                                                        Pair("type", "change"),
                                                                        Pair("side", "bid"),
                                                                        Pair("price", 54350.40),
                                                                        Pair("remaining", 0.002),
                                                                        Pair("delta", 0.002),
                                                                        Pair("reason", "place")
                                                                ))),
                                                        ))
                                                        .build(),
                                                MessageExample.builder()
                                                        .name("heartbeatMessage")
                                                        .summary("Example of additional heartbeat message when you enable them.")
                                                        .payload(mapOf(
                                                                Pair("type", "heartbeat"),
                                                                Pair("socket_sequence", 1656)
                                                        ))
                                                        .build(),
                                        ))
                                        .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("market", AsyncAPISchema.builder()
                                .type("object")
                                .oneOf(listOf(
                                        AsyncAPISchema.builder().ref("#/components/schemas/heartbeat").build(),
                                        AsyncAPISchema.builder().ref("#/components/schemas/update").build(),
                                ))
                                .build()
                        ),
                        Pair("heartbeat", AsyncAPISchema.builder()
                                .allOf(listOf(
                                        AsyncAPISchema.builder()
                                                .properties(mapOf(
                                                        Pair("type", AsyncAPISchema.builder().type("string").constValue("heartbeat").build())
                                                ))
                                                .required(listOf("type"))
                                                .build(),
                                        AsyncAPISchema.builder()
                                                .ref("#/components/schemas/default")
                                                .build(),
                                ))
                                .build()
                        ),
                        Pair("update", AsyncAPISchema.builder()
                                .allOf(listOf(
                                        AsyncAPISchema.builder()
                                                .properties(mapOf(
                                                        Pair("type", AsyncAPISchema.builder().type("string").constValue("update").build()),
                                                        Pair("eventId", AsyncAPISchema.builder()
                                                                .type("integer")
                                                                .description(
                                                                        "A monotonically increasing sequence number indicating when this " +
                                                                        "change occurred. These numbers are persistent and consistent " +
                                                                        "between market data connections."
                                                                )
                                                                .build()
                                                        ),
                                                        Pair("events", AsyncAPISchema.builder().ref("#/components/schemas/events").build()),
                                                        Pair("timestamp", AsyncAPISchema.builder()
                                                                .type("number")
                                                                .description(
                                                                        "The timestamp in seconds for this group of events (included for " +
                                                                        "compatibility reasons). We recommend using the timestampms field " +
                                                                        "instead."
                                                                )
                                                                .build()
                                                        ),
                                                        Pair("timestampms", AsyncAPISchema.builder()
                                                                .type("number")
                                                                .description("The timestamp in milliseconds for this group of events.")
                                                                .build()
                                                        ),
                                                ))
                                                .required(listOf("type", "eventId", "events", "timestamp", "timestampms"))
                                                .build(),
                                        AsyncAPISchema.builder().ref("#/components/schemas/default").build(),
                                ))
                                .build()
                        ),
                        Pair("default", AsyncAPISchema.builder()
                                .type("object")
                                .description(
                                        "This object is always part of the payload. In case of type=heartbeat, " +
                                        "these are the only fields.")
                                .required(listOf("type", "socket_sequence"))
                                .properties(mapOf(
                                        Pair("socket_sequence", AsyncAPISchema.builder()
                                                .type("integer")
                                                .description(
                                                        "zero-indexed monotonic increasing sequence number attached to each " +
                                                        "message sent - if there is a gap in this sequence, you have missed a " +
                                                        "message. If you choose to enable heartbeats, then heartbeat and " +
                                                        "update messages will share a single increasing sequence. See " +
                                                        "[Sequence Numbers](https://docs.sandbox.gemini.com/websocket-api/#sequence-numbers) " +
                                                        "for more information."
                                                )
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("events", AsyncAPISchema.builder()
                                .type("array")
                                .description("Either a change to the order book, or the indication that a trade has occurred.")
                                .items(AsyncAPISchema.builder()
                                        .type("object")
                                        .additionalProperties(false)
                                        .properties(mapOf(
                                                Pair("type", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .enumValue(listOf("trade", "change", "auction, block_trade"))
                                                        .build()
                                                ),
                                                Pair("price", AsyncAPISchema.builder()
                                                        .type("number")
                                                        .multipleOf(0.01)
                                                        .description("The price of this order book entry.")
                                                        .build()
                                                ),
                                                Pair("side", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .enumValue(listOf("bid", "side"))
                                                        .build()
                                                ),
                                                Pair("reason", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .enumValue(listOf("place", "trade", "cancel", "initial"))
                                                        .description(
                                                                "Indicates why the change has occurred. initial is for the initial " +
                                                                "response message, which will show the entire existing state of the " +
                                                                "order book."
                                                        )
                                                        .build()
                                                ),
                                                Pair("remaining", AsyncAPISchema.builder()
                                                        .type("number")
                                                        .description(
                                                                "The quantity remaining at that price level after this change " +
                                                                "occurred. May be zero if all orders at this price level have been " +
                                                                "filled or canceled."
                                                        )
                                                        .build()
                                                ),
                                                Pair("delta", AsyncAPISchema.builder()
                                                        .type("number")
                                                        .description(
                                                                "The quantity changed. May be negative, if an order is filled or canceled. For initial messages, delta will equal remaining."
                                                        )
                                                        .build()
                                                )
                                        ))
                                        .build()
                                )
                                .build()
                        )
                ))
                .build()
    }

}