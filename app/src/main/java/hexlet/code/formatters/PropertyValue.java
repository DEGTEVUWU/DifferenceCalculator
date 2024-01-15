package hexlet.code.formatters;

public class PropertyValue {
    public static String propertyValue (Object value1) {
        if (value1 instanceof Integer || value1 instanceof Character ||
                value1 instanceof Boolean || value1 instanceof Double || value1 instanceof Float || value1 instanceof Long ||
                value1 == null) {
            return "Simple type";
        } else if(value1 instanceof String) {
            return  "String type";
        } else if (value1.getClass().isArray()) {
            return "Composite type";
        }
        return "Composite type";
    }
}
