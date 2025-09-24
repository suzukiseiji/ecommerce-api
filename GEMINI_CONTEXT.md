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

## Status da Sessão (23/09/2025)

- **Branch Ativa:** `feature/2025/09/orders-service`
- **Última Ação Concluída:**
    - A dependência do Project Lombok foi adicionada ao `pom.xml` principal e ao `orders-service/pom.xml` para reduzir o boilerplate code.
    - A entidade JPA `Order` foi criada em `orders-service/src/main/java/com/ecommerce/orders/domain/Order.java`, contendo os campos `id` (String/UUID), `userId` (String), `status` (String) e `total` (BigDecimal).
- **Próximo Passo Planejado:**
    - Iniciar a definição de como os itens de um pedido (`items`) serão representados. As opções incluem:
        1.  Criar uma nova entidade JPA `OrderItem` com um relacionamento `OneToMany` com `Order`.
        2.  Armazenar os itens como um tipo de dado JSONB diretamente na tabela `orders` (usando `@Column(columnDefinition = "jsonb")`).
    - Discutiremos as vantagens e desvantagens de cada abordagem antes de implementar.

## Condição de Checkpoint
- Ao final de cada sessão de estudo, o usuário pode solicitar um "checkpoint". Neste momento, o `GEMINI_CONTEXT.md` será atualizado com o progresso, o próximo passo detalhado e a data da sessão.
