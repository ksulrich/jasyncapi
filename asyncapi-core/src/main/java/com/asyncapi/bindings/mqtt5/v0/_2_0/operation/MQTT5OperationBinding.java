package com.asyncapi.bindings.mqtt5.v0._2_0.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes MQTT 5 operation binding.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt5#operation-binding-object">MQTT 5 operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTT5OperationBinding extends com.asyncapi.bindings.mqtt5.MQTT5OperationBinding {

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
