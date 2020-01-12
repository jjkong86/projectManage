package task.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import task.exception.JsonParseException;

public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJson(Object target) {
        try {
            return OBJECT_MAPPER.writeValueAsString(target);
        } catch (IOException e) {
            throw new JsonParseException(target.toString(), e);
        }
    }
}
