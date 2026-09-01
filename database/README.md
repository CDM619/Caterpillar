# Database

**MySQL 8.0** is the primary relational database for the Smart Rental Tracking System.

## Stage 2A Status

The core domain model is now connected to MySQL through Spring Boot, Spring Data JPA, and Hibernate.

The following tables are managed automatically by Hibernate:

- `equipment`
- `sites`
- `operators`
- `rentals`
- `usage_logs`

Hibernate is configured with:

```properties
spring.jpa.hibernate.ddl-auto=update