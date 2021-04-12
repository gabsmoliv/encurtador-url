# encurtador-url

## Descrição

  Sistema de encurtamento de urls desenvolvido para o processo seletivo Logique Sistema. A partir de urls válidas um usuário cadastrado no sistema podera realizar operações e usar suas urls de formas mais práticas.

### Tecnologias

Tecnologias usadas para desenvolver a solução:

* [**JAVA**] - Linguagem multiplataforma de alto desempenho; Versão usada 11;
* [**SRPING MVC**] - Framework para desenvolvimento de aplicações web;
* [**MYSQL**] - Banco de dados relacional mantido pela oracle;
* [**REACT**] - Framework para criar UI web com JavaScript;

### API

Path's:
* /usuarios verbo POST - Path utilizado para cadastrar usuarios;
* /urls verbo POST - Recuperar Urls por usuarios;
* /login verbo POST - Path para realizar login e autenticação na aplicação;
* /encurtar verbo POST - Utilizado para gerar um link encurtado a partir de uma url válida, por exemplo: www.google.com.br encurtado ficaria http://{hostname}/s8mPqX.
* /{urlEncurtada} verbo GET - Utilizado para usar o link encurtado e redirecionar ao original, por exemplo: http://{hostname}/s8mPqX deve redirecionar para www.google.com.br.

Se a aplicação estiver rodando localmente, considerar hostname como localhost:8080.

### INFOS

* IDE = IntelliJ;
* Tecnlogia de Back-End = Spring MVC;
* Tecnlogia de Front-End = BootStrap;
* SGBD = MYSQL;
