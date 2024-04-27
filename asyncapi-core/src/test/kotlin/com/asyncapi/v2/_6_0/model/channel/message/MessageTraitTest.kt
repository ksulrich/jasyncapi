package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.Reference
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._6_0.model.ExternalDocumentation
import com.asyncapi.v2._6_0.model.Tag
import com.asyncapi.v2.schema.Schema
import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.anypointmq.AnypointMQV0_0_1Test
import com.asyncapi.bindings.googlepubsub.GooglePubSubV0_1_0Test
import com.asyncapi.bindings.http.v0._1_0.message.HTTPMessageBindingTest
import com.asyncapi.bindings.ibmmq.v0._1_0.message.IBMMQMessageBindingTest
import com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageBindingTest
import com.asyncapi.bindings.mqtt.v0._1_0.message.MQTTMessageBindingTest

class MessageTraitTest: SerDeTest<MessageTrait>() {

    override fun objectClass() = MessageTrait::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/message/messageTrait.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/message/messageTrait - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/message/messageTrait - wrongly extended.json"

    override fun build(): MessageTrait {
        return MessageTrait.builder()
                .messageId("userSignup")
                .headers(Schema.builder()
                        .type("object")
                        .properties(mapOf(
                                Pair(
                                        "correlationId",
                                        Schema.builder()
                                                .description("Correlation ID set by application")
                                                .type("string")
                                                .build()
                                ),
                                Pair(
                                        "applicationInstanceId",
                                        Schema.builder()
                                                .description("Unique identifier for a given instance of the publishing application")
                                                .type("string")
                                                .build()
                                )
                        ))
                        .build()
                )
                .correlationId(CorrelationId("Default Correlation ID", "\$message.header#/correlationId"))
                .schemaFormat("application/vnd.apache.avro+json;version=1.9.0")
                .contentType("application/json")
                .name("UserSignup")
                .title("User signup")
                .summary("Action to sign a user up.")
                .description("A longer description")
                .tags(listOf(
                        Tag("user", null, null),
                        Tag("signup", null, null),
                        Tag("register", null, null)
                ))
                .externalDocs(ExternalDocumentation("User sign up rules", "messages/sign-up-rules"))
                .bindings(mapOf(
                        Pair("amqp", AMQPV0_2_0Test.messageBinding()),
                        Pair("amqp1", Reference("#/components/messageBindings/amqp1")),
                        Pair("anypointmq", AnypointMQV0_0_1Test.messageBinding()),
                        Pair("googlepubsub", GooglePubSubV0_1_0Test.messageBinding()),
                        Pair("http", HTTPMessageBindingTest().build()),
                        Pair("ibmmq", IBMMQMessageBindingTest().build()),
                        Pair("jms", Reference("#/components/messageBindings/jms")),
                        Pair("kafka", KafkaMessageBindingTest().build()),
                        Pair("mercure", Reference("#/components/messageBindings/mercure")),
                        Pair("mqtt", MQTTMessageBindingTest().build()),
                        Pair("mqtt5", Reference("#/components/messageBindings/mqtt5")),
                        Pair("nats", Reference("#/components/messageBindings/nats")),
                        Pair("pulsar", Reference("#/components/messageBindings/pulsar")),
                        Pair("redis", Reference("#/components/messageBindings/redis")),
                        Pair("sns", Reference("#/components/messageBindings/sns")),
                        Pair("solace", Reference("#/components/messageBindings/solace")),
                        Pair("sqs", Reference("#/components/messageBindings/sqs")),
                        Pair("stomp", Reference("#/components/messageBindings/stomp")),
                        Pair("ws", Reference("#/components/messageBindings/ws"))
                ))
                .examples(listOf(MessageExampleTest().build()))
                .build()
    }

}