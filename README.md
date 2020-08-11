# cfdemo
Example Kotlin project that uses `java-cfenv-boot` to
to autoconfigure datasources from HSDP RDS service broker

The example is geared towards PostgreSQL. Other databases 
should be trivial to configure.

# compiling

`./mvnw package -DskipTests=true`

# deployment

Use the [manifest.example.yml](manifest.example.yml) as template.
The template assumes you have compiled with Java 11.

Once deployed you can navigate to the app and it will show a string
with the result of the PostgreSQL `now()` method confirming the app
is able to connect to the database

# license
License is MIT
