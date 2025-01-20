package com.asyncapi.bindings.solace;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.solace.v0._3_0.channel.SolaceChannelBinding;
import com.asyncapi.bindings.solace.v0._3_0.message.SolaceMessageBinding;
import com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBinding;
import com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationDestination;
import com.asyncapi.bindings.solace.v0._3_0.operation.queue.SolaceOperationQueue;
import com.asyncapi.bindings.solace.v0._3_0.server.SolaceServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.List;

@DisplayName("0.3.0")
public class SolaceV0_3_0Test {

    public static SolaceChannelBinding channelBinding () {
        return new SolaceChannelBinding();
    }

    public static SolaceMessageBinding messageBinding () {
        return new SolaceMessageBinding();
    }

    public static SolaceOperationBinding operationBinding () {
        return SolaceOperationBinding.builder()
                .destinations(List.of(
                        SolaceOperationDestination.builder()
                                .destinationType(SolaceOperationDestination.Type.QUEUE)
                                .queue(SolaceOperationQueue.builder()
                                        .name("CreatedHREvents")
                                        .topicSubscriptions(List.of("person/*/created"))
                                        .accessType(SolaceOperationQueue.AccessType.EXCLUSIVE)
                                        .maxMsgSpoolSize("1,500")
                                        .maxTtl("60")
                                        .build()
                                )
                                .build(),
                        SolaceOperationDestination.builder()
                                .destinationType(SolaceOperationDestination.Type.TOPIC)
                                .topicSubscriptions(List.of("person/*/updated"))
                                .build()
                ))
                .build();
    }

    public static SolaceServerBinding serverBinding () {
        return SolaceServerBinding.builder()
                .msgVpn("solace.private.net")
                .build();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SolaceChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = SolaceChannelBinding.class;
        super.pathToBindingJson                = "/bindings/solace/0.3.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/0.3.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/0.3.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SolaceMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = SolaceMessageBinding.class;
        super.pathToBindingJson                = "/bindings/solace/0.3.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/0.3.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/0.3.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SolaceOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = SolaceOperationBinding.class;
        super.pathToBindingJson                = "/bindings/solace/0.3.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/0.3.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/0.3.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SolaceServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = SolaceServerBinding.class;
        super.pathToBindingJson                = "/bindings/solace/0.3.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/0.3.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/0.3.0/server/binding - wrongly extended.json";
    }}

}
