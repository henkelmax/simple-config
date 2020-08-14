package de.maxhenkel.simpleconfig;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class JSONConfiguration implements Configuration {

    private File file;
    private JSONObject jsonObject;
    private Charset charset;

    /**
     * Creates a new config file if it does not exist
     *
     * @param file    the configuration file
     * @param charset the charset used to save and load the file
     * @throws IOException if the file can't be accessed
     */
    public JSONConfiguration(File file, Charset charset) throws IOException {
        init(file, charset);
    }

    /**
     * Creates a new config file if it does not exist
     * This constructor uses UTF-8 as default charset
     *
     * @param file the configuration file
     * @throws IOException if the file can't be accessed
     */
    public JSONConfiguration(File file) throws IOException {
        init(file, StandardCharsets.UTF_8);
    }

    /**
     * Creates a new config file if it does not exist
     *
     * @param file    the path to the configuration file
     * @param charset the charset used to save and load the file
     * @throws IOException if the file can't be accessed
     */
    public JSONConfiguration(String file, Charset charset) throws IOException {
        init(new File(file), charset);
    }

    /**
     * Creates a new file if it does not exist
     * This constructor uses UTF-8 as default charset
     *
     * @param file the path to the configuration file
     * @throws IOException if the file can't be accessed
     */
    public JSONConfiguration(String file) throws IOException {
        init(file, StandardCharsets.UTF_8);
    }

    private void init(String file, Charset charset) throws IOException {
        init(new File(file), charset);
    }

    private void init(File file, Charset charset) throws IOException {
        this.file = file;
        this.charset = charset;

        if (!file.exists()) {
            file.createNewFile();
            this.jsonObject = new JSONObject();
            save();
            return;
        }

        InputStreamReader reader = new InputStreamReader(new FileInputStream(file), charset);
        this.jsonObject = new JSONObject(IOUtils.toString(reader));
        reader.close();
    }

    protected void save() {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), charset);
            IOUtils.write(jsonObject.toString(1), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        try {
            return jsonObject.getBoolean(key);
        } catch (JSONException e) {
            put(key, defaultValue);
            return defaultValue;
        }
    }

    @Override
    public int getInt(String key, int defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        try {
            return jsonObject.getInt(key);
        } catch (JSONException e) {
            put(key, defaultValue);
            return defaultValue;
        }
    }

    @Override
    public long getLong(String key, long defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        try {
            return jsonObject.getLong(key);
        } catch (JSONException e) {
            put(key, defaultValue);
            return defaultValue;
        }
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        try {
            return jsonObject.getFloat(key);
        } catch (JSONException e) {
            put(key, defaultValue);
            return defaultValue;
        }
    }

    @Override
    public double getDouble(String key, double defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        try {
            return jsonObject.getDouble(key);
        } catch (JSONException e) {
            put(key, defaultValue);
            return defaultValue;
        }
    }

    @Override
    public String getString(String key, String defaultValue) {
        if (key == null) {
            return defaultValue;
        }

        try {
            return jsonObject.getString(key);
        } catch (JSONException e) {
            put(key, defaultValue);
            return defaultValue;
        }
    }

    @Override
    public void put(String key, Object value) {
        jsonObject.put(key, value);
        save();
    }

}
