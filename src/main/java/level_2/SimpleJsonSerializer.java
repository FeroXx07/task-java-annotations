package level_2;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleJsonSerializer {
    static final String QUOTATION = "\"";
    public static String serialize(Object object) throws IllegalArgumentException, IllegalAccessException {
        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");        }

        JsonSerializable jsonSerializable = object.getClass().getAnnotation(JsonSerializable.class);

        if (jsonSerializable == null) {
            throw new IllegalAccessException("Class must have @JsonSerializable");
        }

        Map<String, String> jsonElementsMap = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            jsonElementsMap.put(field.getName(), field.get(object).toString());
        }

        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonElementsMap.entrySet()) {

            if (json.length() > 1) {
                json.append(",");
            }

            json
                .append(QUOTATION)
                .append(entry.getKey())
                .append(QUOTATION)
                .append(":")
                .append(QUOTATION)
                .append(entry.getValue())
                .append(QUOTATION);
        }
        json.append("}");
        return json.toString();
    }
}
