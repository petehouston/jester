package com.dreweaster.jester.infrastructure.driven.eventstore.serialiser.json;

import com.dreweaster.jester.domain.DomainEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javaslang.Function1;
import javaslang.Function2;

public interface JsonEventMappingConfiguration<T extends DomainEvent> {

    JsonEventMappingConfiguration<T> migrateFormat(Function1<JsonNode, JsonNode> migration);

    JsonEventMappingConfiguration<T> migrateClassName(String className);

    void mapper(Function2<T, ObjectNode, JsonNode> serialiseFunction, Function1<JsonNode, T> deserialiseFunction);
}
