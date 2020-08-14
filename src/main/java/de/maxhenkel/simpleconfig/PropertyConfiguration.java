package de.maxhenkel.simpleconfig;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyConfiguration extends ConfigurationBase {

    private Properties properties;
    private File file;
    private Charset charset;

    /**
     * Creates a new config file if it does not exist
     *
     * @param file    the configuration file
     * @param charset the charset used to save and load the file
     * @throws IOException if the file can't be accessed
     */
    public PropertyConfiguration(File file, Charset charset) throws IOException {
        init(file, charset);
    }

    /**
     * Creates a new config file if it does not exist
     * This constructor uses UTF-8 as default charset
     *
     * @param file the configuration file
     * @throws IOException if the file can't be accessed
     */
    public PropertyConfiguration(File file) throws IOException {
        init(file, StandardCharsets.UTF_8);
    }

    /**
     * Creates a new file if it does not exist
     *
     * @param file    the path to the configuration file
     * @param charset the charset used to save and load the file
     * @throws IOException if the file can't be accessed
     */
    public PropertyConfiguration(String file, Charset charset) throws IOException {
        init(new File(file), charset);
    }

    /**
     * Creates a new file if it does not exist
     * This constructor uses UTF-8 as default charset
     *
     * @param file the path to the configuration file
     * @throws IOException if the file can't be accessed
     */
    public PropertyConfiguration(String file) throws IOException {
        init(file, StandardCharsets.UTF_8);
    }

    private void init(String file, Charset charset) throws IOException {
        init(new File(file), charset);
    }

    protected void init(File file, Charset charset) throws IOException {
        this.file = file;
        this.charset = charset;
        properties = new Properties();
        if (!file.exists()) {
            file.createNewFile();
        }

        InputStreamReader reader = new InputStreamReader(new FileInputStream(file), charset);
        properties.load(reader);
        reader.close();
    }

    protected void save() {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), charset);
            properties.store(writer, "");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getString(String key, String defValue) {
        if (key == null) {
            return defValue;
        }
        if (!properties.containsKey(key)) {
            put(key, defValue);
        }

        return String.valueOf(properties.getProperty(key));
    }

    @Override
    public void put(String key, Object value) {
        properties.put(key, value);
        save();
    }

}
