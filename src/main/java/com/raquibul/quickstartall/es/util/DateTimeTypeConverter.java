package com.raquibul.quickstartall.es.util;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateTimeTypeConverter implements JsonSerializer<Date>, JsonDeserializer<Date> {

	@SuppressWarnings("deprecation")
	public Date deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		// TODO Auto-generated method stub
		 return new Date(json.getAsLong());
	}

	public JsonElement serialize(Date src, Type arg1, JsonSerializationContext arg2) {
		return new JsonPrimitive(src.getTime());
	}
    // No need for an InstanceCreator since DateTime provides a no-args constructor
   /* @Override
    public JsonElement serialize(Date src, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString())
    }

    @Override
    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        return new DateTime(json.getAsLong()).toDate()

    }*/
}