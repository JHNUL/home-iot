package org.juhanir.message_server.rest.utils;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.BadRequestException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.format.DateTimeParseException;

@Provider
public class InstantParamConverterProvider implements ParamConverterProvider {

    private static final ParamConverter<Instant> CONVERTER = new ParamConverter<>() {

        @Override
        public Instant fromString(String value) {
            try {
                return Instant.parse(value);
            } catch (DateTimeParseException e) {
                throw new BadRequestException("Invalid timestamp");
            }
        }

        @Override
        public String toString(Instant value) {
            return value.toString();
        }
    };

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.equals(Instant.class)) {
            return (ParamConverter<T>) CONVERTER;
        }
        return null;
    }
}