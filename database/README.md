# Database

**MySQL 8.0** is the primary relational database for the Smart Rental
Tracking System.

## Stage 1 status

No schema, tables, or migration scripts exist yet. The backend is configured
to connect to MySQL using environment variables (see
`backend/.env.example`), but no database objects are created in this stage.

## What comes later

In later stages, this folder will contain:

- Schema definition scripts (equipment, sites, operators, rentals,
  check-in/check-out, usage logs, etc.)
- Any migration scripts
- Seed/sample data scripts for local development

Until then, the backend can start and serve `/api/health` without a live
database connection.
