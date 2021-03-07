package org.example.data;

/***
 * Class that contains all the application.properties key value information
 */
public class Property {
    private String key;
    private String defaultValue;

    public String getKey() {
        return key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String toString() {
        return key + "=" + defaultValue;
    }
}
