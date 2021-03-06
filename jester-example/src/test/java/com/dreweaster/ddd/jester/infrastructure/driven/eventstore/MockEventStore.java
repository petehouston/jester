package com.dreweaster.ddd.jester.infrastructure.driven.eventstore;

import com.dreweaster.ddd.jester.application.eventstore.PersistedEvent;
import com.dreweaster.ddd.jester.domain.*;
import com.dreweaster.ddd.jester.infrastructure.driven.eventstore.inmemory.InMemoryEventStore;
import javaslang.collection.List;
import javaslang.concurrent.Future;
import javaslang.concurrent.Promise;

public class MockEventStore extends InMemoryEventStore {

    private boolean loadErrorState = false;

    private boolean saveErrorState = false;

    public void toggleLoadErrorStateOn() {
        loadErrorState = true;
    }

    public void toggleLoadErrorStateOff() {
        loadErrorState = false;
    }

    public void toggleSaveErrorStateOn() {
        saveErrorState = true;
    }

    public void toggleSaveErrorStateOff() {
        saveErrorState = false;
    }

    @Override
    public synchronized <A extends Aggregate<?, E, ?>, E extends DomainEvent> Future<List<PersistedEvent<A, E>>> loadEvents(
            AggregateType<A, ?, E, ?> aggregateType,
            AggregateId aggregateId) {

        if (loadErrorState) {
            Promise<List<PersistedEvent<A, E>>> promise = Promise.make();
            promise.failure(new OptimisticConcurrencyException());
            return promise.future();
        }
        return super.loadEvents(aggregateType, aggregateId);
    }

    @Override
    public synchronized <A extends Aggregate<?, E, ?>, E extends DomainEvent> Future<List<PersistedEvent<A, E>>> saveEvents(
            AggregateType<A, ?, E, ?> aggregateType,
            AggregateId aggregateId,
            CausationId causationId,
            List<E> rawEvents,
            Long expectedSequenceNumber) {
        if (saveErrorState) {
            return Future.failed(new IllegalStateException());
        } else {
            return super.saveEvents(aggregateType, aggregateId, causationId, rawEvents, expectedSequenceNumber);
        }
    }

    @Override
    public synchronized <A extends Aggregate<?, E, ?>, E extends DomainEvent> Future<List<PersistedEvent<A, E>>> saveEvents(
            AggregateType<A, ?, E, ?> aggregateType,
            AggregateId aggregateId,
            CausationId causationId,
            CorrelationId correlationId,
            List<E> rawEvents,
            Long expectedSequenceNumber) {
        if (saveErrorState) {
            return Future.failed(new IllegalStateException());
        } else {
            return super.saveEvents(aggregateType, aggregateId, causationId, correlationId, rawEvents, expectedSequenceNumber);
        }
    }
}
