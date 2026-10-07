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
  <tbody><tr><td width="99999">Building a Spring Boot service that exposes REST endpoints for managing book catalogue entries plus author details through layered components with input validation and proper error handling responses.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Persisting book plus author entities within a PostgreSQL database via Spring Data Jpa combined with Hibernate and transactional methods ensures reliable data storage across all retrieval operations.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Accelerating repeated catalogue searches through individual book record caching inside Redis with automatic eviction after updates plus deletions keeps stored information fresh during busy periods.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Securing every restricted route requires Json Web Tokens issued at login and verified by a dedicated filter on each request which enforces stateless authorization across all active sessions.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Enabling new user registration with assigned roles plus encrypted passwords allows administrators to gain privileged access for removing outdated catalogue entries from the entire system safely.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Dispatching new book arrival notifications onto an Apache Kafka topic enables downstream subscribers to process incoming catalogue changes instantly while maintaining reliable message delivery.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Generating interactive OpenApi reference pages through Swagger Ui enables engineers to browse available routes plus execute sample calls directly from any modern browser without extra software.</td><td>✅</td></tr></tbody>
  <tbody><tr><td>Deploying the full stack including PostgreSQL Redis plus Kafka nodes via Docker Compose scripts with health probes and startup ordering delivers a production ready environment for instant use.</td><td>✅</td></tr></tbody>
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