package de.maxhenkel.simpleconfig;

public interface Configuration {

    boolean getBoolean(String key, boolean defaultValue);

    int getInt(String key, int defaultValue);

    long getLong(String key, long defaultValue);

    float getFloat(String key, float defaultValue);

    double getDouble(String key, double defaultValue);

    String getString(String key, String defaultValue);

    void put(String key, Object value);

}
