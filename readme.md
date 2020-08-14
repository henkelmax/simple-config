# Simple Config

A very simple configuration library for Java.

## Example

``` java
Configuration config = new PropertyConfiguration(new File("config.properties"));
// or
Configuration config = new JSONConfiguration(new File("config.json"));

// Reads from the config or defaults to the second parameter and saves it
String testString = config.getString("string-test", "Hello World!");
int testInt = config.getInt("int-test", 123);
double testDouble = config.getDouble("double-test", 12.3D);

// Writes to the config
config.put("string-test", "Hello World!");
config.put("int-test", 123);
config.put("double-test", 12.3D);
```