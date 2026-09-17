# FHIR Patient REST API

A Spring Boot REST API implementing FHIR R4 Patient resource endpoints — built to learn the Java and Spring Boot stack used by SAP Health Data Services for FHIR (HDSF).

## What this is

This is a miniature version of the inbound integration pattern HDSF uses when a hospital information system sends patient data to SAP. It accepts and returns FHIR R4-compliant Patient JSON.

## Endpoints

| Method | Endpoint | Description | Status |
|--------|----------|-------------|--------|
| POST | `/fhir/Patient` | Register a new patient | 201 Created |
| GET | `/fhir/Patient/{id}` | Retrieve a patient by ID | 200 OK / 404 Not Found |

## FHIR R4 Patient structure

```json
{
  "resourceType": "Patient",
  "id": "1",
  "name": [{ "family": "Muller", "given": ["Anna"] }],
  "birthDate": "1990-01-15",
  "gender": "female"
}
```

## Architecture

Follows the Controller → Service pattern with dependency injection:

- **PatientController** — handles HTTP requests, routes to service, returns responses
- **PatientService** — business logic, ID assignment, in-memory storage (HashMap)
- **Patient** — FHIR R4 Patient record (resourceType, id, name, birthDate, gender)

## Running locally

```bash
./mvnw.cmd spring-boot:run
```

API runs on `http://localhost:8080`.

## Testing

**Create a patient:**
```bash
curl -X POST http://localhost:8080/fhir/Patient \
  -H "Content-Type: application/json" \
  -d "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Muller\",\"given\":[\"Anna\"]}],\"birthDate\":\"1990-01-15\",\"gender\":\"female\"}"
```

**Retrieve a patient:**
```bash
curl http://localhost:8080/fhir/Patient/1
```

## Tech stack

- Java 21
- Spring Boot 4.1.1
- Maven (via wrapper)

## Context

Built as part of learning the Java/Spring Boot stack for SAP Healthcare integration work
