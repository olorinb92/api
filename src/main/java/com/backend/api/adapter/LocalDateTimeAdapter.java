package com.backend.api.adapter;

import com.backend.api.helper.DateTimeHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime> {

    @Override
    public JsonElement serialize(LocalDateTime src, Type srcType, JsonSerializationContext context) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimeHelper.YYYY_MM_DD_HH_MM_SS);
        String date = src.format(formatter);
        return new JsonPrimitive(date);
    }

}