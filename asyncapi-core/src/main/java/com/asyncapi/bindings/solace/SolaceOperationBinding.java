package com.asyncapi.bindings.solace;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes Solace operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @see <a href="https://solace.com">Solace</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.solace.v0._4_0.operation.SolaceOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.solace.v0._1_0.operation.SolaceOperationBinding.class, names = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.solace.v0._2_0.operation.SolaceOperationBinding.class, names = "0.2.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBinding.class, names = "0.3.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.solace.v0._4_0.operation.SolaceOperationBinding.class, names = {
                "0.4.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SolaceOperationBinding extends OperationBinding {}