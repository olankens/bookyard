<div align="center">
  <p><img src=".assets/icon.avif" align="center" width="128"></p>
  <h1><code>BOOKYARD</code></h1>
</div>

<table>
  <tbody><tr><td align="center" width="99999"><div>
    <a href="https://olankens.com">WEBSITE</a> ·
    <a href="https://ko-fi.com/olankens">FUNDING</a>
  </div></td></tr></tbody>
  <tbody><tr><td align="center" width="99999">&nbsp;<div>
    Spring Boot REST API for new book catalogue records with PostgreSQL persistence, Redis caching, JWTs authentication, Kafka messaging, OpenAPI full docs, Docker Compose deployment for skilled developers.
  </div>&nbsp;</td></tr></tbody>
  <tbody><tr><td align="center" width="99999">
    <a href="https://spring.io"><img src=".assets/logo-spring.svg" align="center" width="56"></a>
    <picture><img src=".assets/splitter.gif" align="center" height="40" width="1"/></picture>
    <a href="https://postgresql.org"><img src=".assets/logo-postgresql.svg" align="center" width="56"></a>
    <picture><img src=".assets/splitter.gif" align="center" height="40" width="1"/></picture>
    <a href="https://redis.io"><img src=".assets/logo-redis.svg" align="center" width="56"></a>
    <picture><img src=".assets/splitter.gif" align="center" height="40" width="1"/></picture>
    <a href="https://kafka.apache.org"><img src=".assets/logo-apachekafka.svg" align="center" width="56"></a>
    <picture><img src=".assets/splitter.gif" align="center" height="40" width="1"/></picture>
    <a href="https://docker.com"><img src=".assets/logo-docker.svg" align="center" width="56"></a>
  </td></tr></tbody>
</table>

## PREVIEWS

<table><tbody><tr><td width="99999">
  <img src=".assets/preview-01.avif" align="center" width="49.21875%"><picture><img src=".assets/spacer.gif" align="center" width="1.5625%"></picture><img src=".assets/preview-02.avif" align="center" width="49.21875%">
</td></tr></tbody></table>

## FEATURES

<table>
  <tbody><tr><td width="99999">Builds a Spring Boot 4 application with REST endpoints for managing book catalogue records and author data through a clean layered architecture with input validation and error handling.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Persists book and author entities to a PostgreSQL database using Spring Data JPA with Hibernate and transactional service methods for reliable data storage and retrieval operations across services.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Accelerates repeated book lookups by caching individual records in Redis with automatic cache eviction on updates and deletions to keep data fresh at all times for better performance gains.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Secures every protected endpoint with JSON Web Tokens issued at login and validated by a custom filter on each incoming request for stateless authentication and authorization flow control.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Registers new user accounts with a chosen role and password enabling role based access control for administrative operations like deleting book records from the entire system catalog safely.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Dispatches book creation events to an Apache Kafka topic so downstream consumers can react to new catalogue entries in real time with reliable message delivery and error handling logic.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Generates interactive OpenAPI documentation with Swagger UI so developers can explore every endpoint and test requests directly from a browser interface page without extra tools needed.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Deploys the application alongside PostgreSQL, Redis, and Kafka containers via Docker Compose with health checks and dependency ordering for a ready to run stack in production environments easily.</td><td>✅</td></tr></tbody>
</table>

## LEARNING

### LAUNCH IN INTELLIJ IDEA

```shell
idea .
```

### INVOKE THE CONTAINERS

```shell
docker compose down
docker compose up --build
```

### PREPARE NODE TOOLING

```shell
command -v pnpm >/dev/null && pnpm install || npm install
```