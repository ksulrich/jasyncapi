package com.asyncapi.v2._0_0.model.channel

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._0_0.model.channel.operation.OperationWithMessageTest
import com.asyncapi.v2._0_0.model.channel.operation.OperationWithReferenceToMessageTest
import com.asyncapi.v2.schema.Schema
import com.asyncapi.bindings.ChannelBinding
import com.asyncapi.bindings.amqp.v0._2_0.channel.AMQPChannelBindingTest
import com.asyncapi.bindings.amqp1.v0._1_0.channel.AMQP1ChannelBinding
import com.asyncapi.bindings.anypointmq.v0._0_1.channel.AnypointMQChannelBindingTest
import com.asyncapi.v2.binding.channel.googlepubsub.GooglePubSubChannelBindingTest
import com.asyncapi.bindings.http.v0._1_0.channel.HTTPChannelBinding
import com.asyncapi.v2.binding.channel.ibmmq.IBMMQChannelBindingTest
import com.asyncapi.bindings.jms.v0._0_1.channel.JMSChannelBinding
import com.asyncapi.v2.binding.channel.kafka.KafkaChannelBindingTest
import com.asyncapi.bindings.mercure.v0._1_0.channel.MercureChannelBinding
import com.asyncapi.bindings.mqtt.v0._1_0.channel.MQTTChannelBinding
import com.asyncapi.bindings.mqtt5.v0._2_0.channel.MQTT5ChannelBinding
import com.asyncapi.bindings.nats.v0._1_0.channel.NATSChannelBinding
import com.asyncapi.v2.binding.channel.pulsar.PulsarChannelBindingTest
import com.asyncapi.bindings.redis.v0._1_0.channel.RedisChannelBinding
import com.asyncapi.bindings.sns.v0._1_0.channel.SNSChannelBinding
import com.asyncapi.bindings.solace.v0._3_0.channel.SolaceChannelBinding
import com.asyncapi.bindings.sqs.v0._1_0.channel.SQSChannelBinding
import com.asyncapi.bindings.stomp.v0._1_0.channel.STOMPChannelBinding
import com.asyncapi.v2.binding.channel.ws.WebSocketsChannelBindingTest

class ChannelItemTest: SerDeTest<ChannelItem>() {

    override fun objectClass() = ChannelItem::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/channel/channelItem.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/channel/channelItem - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/channel/channelItem - wrongly extended.json"

    override fun build(): ChannelItem {
        val subscribe = OperationWithReferenceToMessageTest().build()
        val publish = OperationWithMessageTest().build()
        val userIdParameter = ParameterTest().build()
        userIdParameter.schema = Schema.builder().type("string").build()

        return ChannelItem.builder()
                .description("This channel is used to exchange messages about users signing up")
                .subscribe(subscribe)
                .publish(publish)
                .parameters(mapOf(
                        Pair("userId", userIdParameter)
                ))
                .bindings(bindings())
                .build()
    }

    companion object {
        fun bindings(): Map<String, ChannelBinding> {
            return mapOf(
                    Pair("amqp", AMQPChannelBindingTest().build()),
                    Pair("amqp1", AMQP1ChannelBinding()),
                    Pair("anypointmq", AnypointMQChannelBindingTest().build()),
                    Pair("googlepubsub", GooglePubSubChannelBindingTest().build()),
                    Pair("http", HTTPChannelBinding()),
                    Pair("ibmmq", IBMMQChannelBindingTest().build()),
                    Pair("jms", JMSChannelBinding()),
                    Pair("kafka", KafkaChannelBindingTest().build()),
                    Pair("mercure", MercureChannelBinding()),
                    Pair("mqtt", MQTTChannelBinding()),
                    Pair("mqtt5", MQTT5ChannelBinding()),
                    Pair("nats", NATSChannelBinding()),
                    Pair("pulsar", PulsarChannelBindingTest().build()),
                    Pair("redis", RedisChannelBinding()),
                    Pair("sns", SNSChannelBinding()),
                    Pair("solace", SolaceChannelBinding()),
                    Pair("sqs", SQSChannelBinding()),
                    Pair("stomp", STOMPChannelBinding()),
                    Pair("ws", WebSocketsChannelBindingTest().build())
            )
        }
    }

}