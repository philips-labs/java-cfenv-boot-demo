# cfdemo-java-cfenv
Example Kotlin project that uses `java-cfenv-boot` to
to autoconfigure datasources from HSDP RDS service broker

The example is geared towards PostgreSQL. Other databases 
should be trivial to configure.

# details

The [HSDPPostgresEnvProcessor](src/main/kotlin/com/terrakube/cfdemo/HSDPPostgresEnvProcessor.kt) class
demostrates how to implement [CfEnvProcessor](https://github.com/pivotal-cf/java-cfenv/blob/master/java-cfenv-boot/src/main/java/io/pivotal/cfenv/spring/boot/CfEnvProcessor.java) in order to discover and use the service broker properties.

It's crucial to add your custom class to [spring.proprties](src/main/resources/META-INF/spring.factories). In this example
the entry looks like:

```
io.pivotal.cfenv.spring.boot.CfEnvProcessor=com.terrakube.cfdemo.HSDPPostgresEnvProcessor
```

# compiling

`./mvnw package -DskipTests=true`

# deployment

Use the [manifest.example.yml](manifest.example.yml) as template.
The template assumes you have compiled with Java 11.

Once deployed you can navigate to the app and it will show a string
with the result of the PostgreSQL `now()` method, confirming the app
is connected to your PostgreSQL database.

```
hello world: 11 Aug 2020 02:01:09PM
```

# license
License is MIT
