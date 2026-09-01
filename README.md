# Smart Rental Tracking System

A full-stack system for tracking rented industrial equipment used in
industries such as construction and mining — covering asset tracking,
sites/operators, rentals, check-in/check-out, usage logging, and (in later
stages) dashboards, overdue alerts, anomaly detection, demand forecasting,
and AI-assisted recommendations.

The long-term product narrative is **SPOT → EXPLAIN → ACT → PREDICT → PROVE**.

## Current Stage

**Stage 1 — Foundation.** This stage only sets up a clean, runnable
full-stack skeleton. No business logic, entities, CRUD, or AI/intelligence
features are implemented yet.

## Tech Stack

**Frontend**
- React
- TypeScript
- Vite
- Tailwind CSS (added in a later stage)

**Backend**
- Java 21
- Spring Boot
- Maven Wrapper
- Spring Web
- Spring Data JPA / Hibernate
- Spring Validation

**Database**
- MySQL 8.0

This is a simple modular monolith — no microservices, Docker, message
queues, or additional data stores are used.

## Project Structure

```
Caterpillar/
├── frontend/     React + TypeScript + Vite app
├── backend/      Spring Boot app (Java 21, Maven Wrapper)
├── database/     Database documentation (schema added in later stages)
├── README.md
└── .gitignore
```

## Running the Backend

Requires Java 21 and internet access on first run (the Maven Wrapper
downloads Maven itself and all dependencies from Maven Central).

```bash
cd backend
./mvnw spring-boot:run
```

The backend starts on **http://localhost:8080**.

Verify it's running:

```bash
curl http://localhost:8080/api/health
```

Expected response:

```json
{
  "status": "UP",
  "service": "smart-rental-backend"
}
```

### Database configuration (optional for Stage 1)

The backend does not require MySQL to be running in Stage 1 — the health
endpoint works without a database connection. When you're ready to connect
a real MySQL instance, copy `backend/.env.example` and set these
environment variables before starting the app:

- `DB_HOST` (default: `localhost`)
- `DB_PORT` (default: `3306`)
- `DB_NAME` (default: `smart_rental`)
- `DB_USERNAME` (default: `root`)
- `DB_PASSWORD` (no default — set your own)

Never commit real credentials. `.env` files are git-ignored; only
`.env.example` (placeholders only) is tracked.

## Running the Frontend

Requires Node.js and internet access on first run (npm installs
dependencies from the npm registry).

```bash
cd frontend
npm install
npm run dev
```

The frontend starts on **http://localhost:5173** and will attempt to call
the backend's `/api/health` endpoint, showing either "Backend: Connected"
or a disconnected state if the backend isn't running.

## Roadmap (future stages)

- Equipment / site / operator entities and CRUD
- Rentals and check-in/check-out
- Usage logging and asset dashboard
- Overdue alerts
- Anomaly detection
- Demand forecasting
- Explainable recommendations
- AI/RAG interaction
