package com.asyncapi.v2._6_0.jackson.model.channel.message;

import com.asyncapi.schemas.Reference;
import com.asyncapi.v2._6_0.model.channel.message.MessageTrait;
import com.asyncapi.v2.jackson.ListOfReferencesOrObjectsDeserializer;

/**
 * Serializes message traits list.
 *
 * @author Pavel Bodiachevskii
 */
public class MessageTraitsDeserializer extends ListOfReferencesOrObjectsDeserializer<MessageTrait> {

    @Override
    public Class<MessageTrait> objectTypeClass() {
        return MessageTrait.class;
    }

    @Override
    public Class<?> referenceClass() {
        return Reference.class;
    }

}
