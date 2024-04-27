package com.asyncapi.bindings.googlepubsub;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.googlepubsub.v0._2_0.channel.GooglePubSubChannelBinding;
import com.asyncapi.bindings.googlepubsub.v0._2_0.message.GooglePubSubMessageBinding;
import com.asyncapi.bindings.googlepubsub.v0._2_0.operation.GooglePubSubOperationBinding;
import com.asyncapi.bindings.googlepubsub.v0._2_0.server.GooglePubSubServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class GooglePubSubUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<com.asyncapi.bindings.googlepubsub.v0._2_0.channel.GooglePubSubChannelBinding> {{
        super.binding                          = GooglePubSubV0_2_0Test.channelBinding();
        super.bindingTypeClass                 = GooglePubSubChannelBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<com.asyncapi.bindings.googlepubsub.v0._2_0.message.GooglePubSubMessageBinding> {{
        super.binding                          = GooglePubSubV0_2_0Test.messageBinding();
        super.bindingTypeClass                 = GooglePubSubMessageBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<com.asyncapi.bindings.googlepubsub.v0._2_0.operation.GooglePubSubOperationBinding> {{
        super.binding                          = GooglePubSubV0_2_0Test.operationBinding();
        super.bindingTypeClass                 = GooglePubSubOperationBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<com.asyncapi.bindings.googlepubsub.v0._2_0.server.GooglePubSubServerBinding> {{
        super.binding                          = GooglePubSubV0_2_0Test.serverBinding();
        super.bindingTypeClass                 = GooglePubSubServerBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/unknown version/server/binding - wrongly extended.json";
    }}

}
