package com.vladimiro.shift.provider.resource.deserializer;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Class DefaultInstantDeserializer was defined because {@link com.fasterxml.jackson.databind.JsonDeserializer}
 * only accepts default constructor which {@link InstantDeserializer} does not have.
 */
public class DefaultInstantDeserializer extends InstantDeserializer<Instant> {

    public DefaultInstantDeserializer() {
        super(Instant.class, DateTimeFormatter.ISO_INSTANT, Instant::from,
                a -> Instant.ofEpochMilli(a.value),
                a -> Instant.ofEpochSecond(a.integer, a.fraction),
                null, true);
    }
}
