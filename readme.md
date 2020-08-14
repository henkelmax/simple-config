# Simple Config ![GitHub Workflow Status](https://img.shields.io/github/workflow/status/henkelmax/simple-config/Build) ![GitHub issues](https://img.shields.io/github/issues-raw/henkelmax/simple-config) ![GitHub release (latest by date)](https://img.shields.io/github/v/release/henkelmax/simple-config?include_prereleases)


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

## Maven

**Dependency**

``` xml
<dependency>
  <groupId>de.maxhenkel.simpleconfig</groupId>
  <artifactId>simple-config</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

**Repository**

``` xml
<repository>
  <id>henkelmax</id>
  <url>https://maven.maxhenkel.de/repository/public</url>
</repository>
```
<!--``` xml
<repository>
  <id>simple-config</id>
  <name>GitHub Simple Config Maven Packages</name>
  <url>https://maven.pkg.github.com/henkelmax/simple-config</url>
</repository>
```-->