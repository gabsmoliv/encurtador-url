# Encurtador-url

## DESCRIÇÂO

Uma api com o proposito de encurtar urls, permitindo realizar operações e usar suas urls de formas mais práticas.

### TECNOLOGIAS

Tecnologias usadas para desenvolver a solução:

* [**Kotlin**] - Linguagem multiplataforma de alto desempenho;
* [**Spring**] - Framework para desenvolvimento de aplicações web;
* [**Mongo**] - Banco de dados não relacional;
* [**Kafka**] - Plataforma unificada, de alta capacidade e baixa latência para tratamento de dados em tempo real;
* [**Redis**] - Banco de armazenamento de estrutura de dados em memória;

### API

Endpoints:
* POST /shorter-url - Path para realização o encurtamento das URLs;
* GET /{shortenedUrl} - Path que redireciona para a URL original a partir da da encurtada.
