# Climate Monitoring System

Este projeto é um sistema de monitoramento climático desenvolvido em **Java** utilizando o framework **Spring Boot**. O objetivo do sistema é fornecer uma base inicial para monitorar e gerenciar dados relacionados ao clima. 

---

## 🚀 O que foi feito até agora?

### 1. **Estrutura Inicial do Projeto**
- O projeto foi configurado utilizando o **Spring Boot**.
- Foi criado um arquivo `pom.xml` para gerenciar as dependências do Maven, incluindo:
  - `spring-boot-starter-web` para desenvolvimento de APIs REST.
  - `spring-boot-starter-json` e `jackson-databind` para manipulação de dados JSON.
  - `spring-boot-starter-actuator` para monitoramento da aplicação.
  - `spring-boot-devtools` para facilitar o desenvolvimento com funcionalidades como LiveReload.
  - `lombok` para reduzir boilerplate no código.
  - Dependências de teste, como `spring-boot-starter-test` e `gson`.

---

### 2. **Configuração do Maven**
- O **Maven Wrapper** foi configurado, permitindo que o projeto seja facilmente executado sem a necessidade de instalar o Maven globalmente.
- Foi incluído o arquivo `mvnw.cmd` para facilitar o uso do Maven em sistemas Windows.
- O arquivo `pom.xml` foi ajustado para evitar duplicidades nas dependências e plugins.

---

### 3. **Estrutura do Código**
- Foi criada a classe principal `ClimatemonitoringApplication.java`, que serve como ponto de entrada para a aplicação Spring Boot.
- Inicialmente, foi configurado um arquivo `application.properties` em `src/main/resources` para ajustes simples na aplicação.

---

### 4. **Controle de Versão**
- O repositório foi inicializado com **Git**.
- O código foi sincronizado com o GitHub no repositório: [Climate Monitoring System](https://github.com/Nanycs13/climate-monitoring-system).
- Foram realizados os seguintes passos no GitHub:
  - Configuração do branch principal `main`.
  - Resolução de conflitos entre o repositório local e remoto.
  - Push bem-sucedido dos arquivos para o repositório remoto.

---

## 🛠️ Como rodar o projeto?

1. **Pré-requisitos**
   - **Java 17** ou versão superior instalado.
   - Git instalado no seu sistema.
   - Opcional: Maven instalado globalmente (não necessário se usar o Maven Wrapper).

2. **Clonar o repositório**
   ```bash
   git clone https://github.com/Nanycs13/climate-monitoring-system.git
   cd climate-monitoring-system/climatemonitoring
   ```

3. **Executar o projeto**
   - Com o Maven Wrapper:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou com Maven global:
     ```bash
     mvn spring-boot:run
     ```

4. **Acessar a aplicação**
   - Acesse o sistema em: [http://localhost:8080](http://localhost:8080).

---

## 📂 Estrutura do Projeto
```
climatemonitoring
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.climatemonitoring
│   │   │       ├── ClimatemonitoringApplication.java
│   │   ├── resources
│   │       └── application.properties
│   └── test
│       ├── java
│           └── com.example.climatemonitoring
│               └── ClimatemonitoringApplicationTests.java
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 🌟 Próximos Passos

### Funcionalidades Planejadas:
- Criação de endpoints REST para processar dados climáticos.
- Integração com APIs externas para obter dados meteorológicos.
- Persistência de dados utilizando um banco de dados relacional (ex.: MySQL ou PostgreSQL).
- Testes unitários e de integração para garantir a qualidade do código.

---

## 🤝 Contribuindo
1. Faça um fork do repositório.
2. Crie uma branch para sua funcionalidade (`git checkout -b minha-funcionalidade`).
3. Faça commit das suas alterações (`git commit -m 'Adicionei minha funcionalidade'`).
4. Faça push para a branch (`git push origin minha-funcionalidade`).
5. Abra um Pull Request.

---

## 📜 Licença
Este projeto é apenas para fins educacionais e não possui uma licença específica no momento.

---

Se tiver dúvidas ou sugestões, por favor, entre em contato ou abra uma **issue** no repositório.
