# Camel Quarkus Infinispan Demo

To run this project, you must first build the latest Quarkus & Camel Quarkus SNAPSHOTs.

1. Ensure you have a locally built Quarkus `999-SNAPSHOT`
2. Clone the [Camel Quarkus](https://github.com/apache/camel-quarkus) source, switch to the `quarkus-main` branch and build the project: `mvn clean install -Dquickly -T1C`
3. Modify the property values in `application.properties` to suit your local Infinispan server
4. Create a cache in Infinispan named `camel`

With the above prerequisites in place, you can run the demo app tests `mvn clean test`. 
