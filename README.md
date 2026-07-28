# 📝 Organizador de Tarefas com Prioridade Contextual

[![Java](https://img.shields.io/badge/Java-17-orange)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green)]()
[![Build](https://img.shields.io/badge/build-Maven-blue)]()

## 📖 Descrição
API REST para organizar tarefas com **prioridade dinâmica**, calculada automaticamente de acordo com:
- Prazo (tarefas próximas do vencimento ganham prioridade)
- Hora do dia (manhã favorece foco)

## 🚀 Funcionalidades
- Criar, listar e arquivar tarefas
- Listar tarefas da semana atual
- Prioridade recalculada em tempo real
- Validação de entrada com Bean Validation
- Persistência com JPA e H2 (em memória)

## 📂 Estrutura do Projeto
```
src/
├── main/java/tarefascontextuais/
│   ├── OrganizadorDeTarefasComPrioridadeApplication.java
│   ├── controller/ → Endpoints REST
│   ├── domain/ → Entidades JPA
│   ├── dto/ → DTOs de entrada e saída
│   ├── repository/ → Interfaces de persistência
│   └── service/ → Regras de negócio e cálculo de prioridade
└── test/java/tarefascontextuais/
    └── OrganizadorDeTarefasComPrioridadeApplicationTests.java
```

## 🔗 Endpoints da API
- `POST /api/tarefas` → Criar nova tarefa (requer: descricao, prazo, prioridadeBase)
- `GET /api/tarefas` → Listar tarefas ativas (ordenadas por prioridade calculada)
- `GET /api/tarefas/semana` → Listar tarefas da semana atual
- `POST /api/tarefas/{id}/arquivar` → Arquivar tarefa por ID

### Exemplo de Request (POST /api/tarefas)
```json
{
  "descricao": "Revisar código",
  "prazo": "2025-12-25",
  "prioridadeBase": 3
}
```

## ⚙️ Regras de Cálculo de Prioridade
A prioridade final é calculada dinamicamente:
- Base: 1-5 (definida pelo usuário)
- -1 se prazo ≤ 2 dias
- -1 se horário atual entre 6:00-11:59 (manhã)
- Resultado clamped entre 1-5

**Exemplo**: Base 3, prazo amanhã, manhã → prioridade = 1

## 🛠️ Pré-requisitos
- Java 17 ou superior
- Maven 3.6+ (ou use o wrapper incluído)

## ▶️ Execução Local

### Compilar
```bash
./mvnw.cmd clean compile
```

### Executar Testes
```bash
./mvnw.cmd test
```

### Executar Aplicação
```bash
./mvnw.cmd spring-boot:run
```
A aplicação iniciará na porta 8080.

### Banco de Dados
- Usa H2 em memória (dados não persistidos entre execuções)
- Console H2: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:testdb)

## 📦 Dependências Principais
- Spring Boot 3.5.7
- Spring Data JPA
- Spring Validation
- H2 Database
- Lombok


## 🤝 Contribuição
1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para detalhes.
