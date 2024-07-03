Este repositório contém a implementação do Desafio Backend que realizei. O objetivo principal foi desenvolver um aplicativo utilizando Spring Boot para gerenciar e enviar notificações agendadas de forma automatizada.

Aprendizados e Tecnologias Utilizadas:
Spring Boot Microserviço: Criei uma aplicação Java utilizando Spring Boot para facilitar o desenvolvimento e manutenção do serviço.

Spring Scheduler: Implementei tarefas agendadas usando o Spring Scheduler para automatizar o envio de notificações em horários específicos.

Integração com MySQL via Docker: Configurei um ambiente de desenvolvimento usando Docker para integrar e gerenciar o banco de dados MySQL.

Spring Data JPA: Utilizei o Spring Data JPA para realizar operações de banco de dados e consultas customizadas de forma eficiente.

Entidades e Relacionamentos: Modelei e implementei entidades como Notification, Channel e Status com relacionamentos ManyToOne usando JoinColumn.

Logging com SLF4J: Implementei logs utilizando SLF4J para monitorar o fluxo de execução e identificar problemas potenciais no aplicativo.

Funcionalidades Implementadas:
O aplicativo permite:

Agendamento de Notificações: Os usuários podem agendar notificações que serão enviadas automaticamente conforme o horário especificado.

Consulta e Cancelamento: Implementei funcionalidades para consultar o status das notificações agendadas e cancelar aquelas que não são mais necessárias.

