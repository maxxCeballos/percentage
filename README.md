# Profit Service

## Ejecutar la app

Desde la terminal, estando en el root del proyecto ejecutar los comandos:

1. mvn clean install -DskipTests
2. docker-compose build --no-cache
3. docker-compose up -d
4. mvn spring-boot:run

Luego importar en postman el archivo tenpo.postman_collection.json ubicado en el root del proyecto para testear los endpoints especificados.
