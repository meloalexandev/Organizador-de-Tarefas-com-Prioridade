# Copilot Instructions for Organizador de Tarefas com Prioridade

## Project Overview
This is a Spring Boot 3 REST API for task management with dynamic priority calculation based on deadlines and time of day. The application uses contextual priority to help users focus on urgent tasks during optimal times.

## Architecture
- **Layered Architecture**: Controller → Service → Repository pattern
- **Domain Model**: `Tarefa` entity in `domain/` package
- **DTOs**: Separate `TarefaRequest` and `TarefaResponse` classes in `dto/` for API contracts
- **Business Logic**: Priority calculation in `PrioridadeContextual` service component
- **Persistence**: JPA repository pattern (currently in-memory with H2)

## Key Components
- **TarefaController**: REST endpoints under `/api/tarefas`
- **TarefaService**: Business logic, priority recalculation, timezone handling
- **PrioridadeContextual**: Priority calculation logic (base priority adjusted by deadline proximity and time of day)
- **TarefaRepository**: Data access layer

## Priority Calculation Rules
Priority is calculated dynamically:
- Base priority: 1-5 (user-defined)
- Subtract 1 if deadline ≤ 2 days away
- Subtract 1 if current time is 6:00-11:59 (morning focus hours)
- Clamped between 1-5

Example: Base 3, deadline tomorrow, morning → priority = max(1, min(5, 3-1-1)) = 1

## Conventions
- **Language**: Portuguese domain terms (Tarefa=task, descricao=description, prazo=deadline, prioridade=priority)
- **Timezone**: America/Sao_Paulo for all date/time operations
- **Validation**: Bean validation on DTOs (@NotBlank, @FutureOrPresent, @Min/@Max)
- **Package Structure**: controller/, domain/, dto/, repository/, service/
- **Naming**: CamelCase for classes, consistent with Spring Boot conventions

## Development Workflow
- **Build**: `mvn clean compile`
- **Run**: `mvn spring-boot:run` (starts on port 8080)
- **Test**: `mvn test` (JUnit 5 with Spring Boot test)
- **Database**: H2 in-memory (no persistent storage configured)

## API Endpoints
- `POST /api/tarefas` - Create task (requires descricao, prazo, prioridadeBase)
- `GET /api/tarefas` - List active tasks (sorted by calculated priority)
- `GET /api/tarefas/semana` - List tasks for current week
- `POST /api/tarefas/{id}/arquivar` - Archive task

## Dependencies
- Spring Boot 3.5.7, Java 17
- Spring Data JPA, Spring Web, Validation
- H2 database, Lombok
- Spring AI (OpenAI integration, not yet implemented)

## Code Patterns
- Use Lombok for boilerplate (getters, constructors)
- Separate DTOs for request/response to avoid exposing internal models
- Service layer handles business logic and timezone conversions
- Repository interfaces extend JpaRepository for CRUD operations</content>
<parameter name="filePath">c:\Users\alexa\Projeto-Java\Organizador de Tarefas com Prioridade\Organizador-de-Tarefas-com-Prioridade-1\.github\copilot-instructions.md