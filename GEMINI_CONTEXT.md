# Contexto do Projeto para o Gemini

## Objetivo do Projeto
Construir um backend de e-commerce com uma Arquitetura Orientada a Eventos (EDA) utilizando Java com Spring Boot 3, RabbitMQ, PostgreSQL e Redis. O projeto é guiado pelo documento `escopo_rabbitmq.pdf`.

## Contexto do Usuário
O usuário está utilizando este projeto para aprender sobre Java, Spring Boot e arquitetura de microserviços. 

**Background Técnico:**
- Linguagem: PHP (com framework Laravel)
- Banco de Dados: MySQL

**Necessidades de Aprendizagem:**
- As explicações devem ser didáticas.
- Devem ser feitas analogias com os conceitos do ecossistema PHP/Laravel para facilitar o entendimento.

## Status da Sessão (28/09/2025)

- **Branch Ativa:** `feature/2025/09/orders-service`
- **Última Ação Concluída:**
    - Implementado o fluxo completo de criação de pedidos (`POST /api/orders`).
    - Criada a entidade `OrderItem` e estabelecido o relacionamento `One-to-Many` com a entidade `Order`.
    - Implementado o padrão DTO (Data Transfer Object) para requisição e resposta, desacoplando a API da camada de persistência.
    - Criadas as camadas de `Controller`, `Service`, `Repository` e `Mapper` para a funcionalidade de pedidos.
    - Corrigido o `pom.xml` pai para gerenciar corretamente as dependências do Spring Boot.
    - Configurada a conexão com o banco de dados no `application.properties`.
    - A aplicação foi executada e o endpoint de criação de pedido foi testado com sucesso via Postman.
- **Próximo Passo Planejado:**
    - Adicionar validações ao DTO de requisição (`CreateOrderRequestDTO`) usando `jakarta.validation.constraints` (ex: `@NotBlank`, `@NotEmpty`) para garantir a integridade dos dados de entrada.
    - Implementar um tratamento de erros de validação customizado (`@ControllerAdvice`) para retornar respostas de erro padronizadas e claras para o cliente da API.

## Condição de Checkpoint
- Ao final de cada sessão de estudo, o usuário pode solicitar um "checkpoint". Neste momento, o `GEMINI_CONTEXT.md` será atualizado com o progresso, o próximo passo detalhado e a data da sessão.

## Convenções de Commit
- As mensagens de commit devem ser escritas em Português do Brasil, utilizando termos comuns da programação em inglês quando apropriado (ex: "feat", "fix", "refactor").