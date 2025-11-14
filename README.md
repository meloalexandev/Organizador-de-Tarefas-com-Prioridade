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

## 📂 Estrutura
- `domain/` → Entidades JPA
- `dto/` → Entrada e saída da API
- `service/` → Regras de negócio
- `controller/` → Endpoints REST
- `repository/` → Persistência

## 🔗 Endpoints principais
- `POST /api/tarefas` → Criar tarefa
- `GET /api/tarefas` → Listar ativas
- `GET /api/tarefas/semana` → Listar semana atual
- `POST /api/tarefas/{id}/arquivar` → Arquivar tarefa

## ▶️ Execução local
```bash
mvn spring-boot:run
