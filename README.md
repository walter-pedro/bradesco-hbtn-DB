# Bradesco Holberton - Projeto JPA

Este é um projeto Java Maven que demonstra o uso de JPA (Java Persistence API) para persistência de dados em um banco de dados relacional. O projeto foi configurado para usar Hibernate como implementação de JPA e H2 como banco de dados em memória.

## Estrutura do Projeto

```
bradesco-hbtn-DB/
├── src/
│   ├── main/
│   │   ├── java/com/holberton/
│   │   │   ├── MainApp.java         # Classe principal para demonstração
│   │   │   ├── model/               # Entidades JPA
│   │   │   │   ├── BaseEntity.java  # Classe base para todas as entidades
│   │   │   │   └── User.java        # Exemplo de entidade
│   │   │   └── util/
│   │   │       └── JpaUtil.java     # Utilitário para gerenciar o EntityManager
│   │   └── resources/
│   │       ├── META-INF/
│   │       │   └── persistence.xml  # Configuração do JPA
│   │       └── logback.xml          # Configuração de logs
│   └── test/                        # Testes unitários (a implementar)
├── .gitignore
├── pom.xml                          # Configuração do Maven
└── README.md
```

## Pré-requisitos

- Java 11 ou superior
- Maven 3.6 ou superior

## Configuração

O projeto já está configurado com as dependências necessárias no arquivo `pom.xml`.

### Configuração do Banco de Dados

O projeto está configurado para usar o banco de dados H2 em memória. Você pode modificar as configurações de conexão no arquivo `src/main/resources/META-INF/persistence.xml` se necessário.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone [URL_DO_REPOSITÓRIO]
   cd bradesco-hbtn-DB
   ```

2. Compile o projeto:
   ```bash
   mvn clean compile
   ```

3. Execute a aplicação:
   ```bash
   mvn exec:java -Dexec.mainClass="com.holberton.MainApp"
   ```

## Funcionalidades Implementadas

- Configuração básica de um projeto Maven com JPA/Hibernate
- Classe base para entidades com campos comuns (ID, timestamps)
- Utilitário para gerenciamento de transações JPA
- Exemplo de entidade `User` com validações básicas
- Demonstração de operações CRUD básicas

## Próximos Passos

- [ ] Adicionar mais entidades de domínio
- [ ] Implementar repositórios customizados
- [ ] Adicionar testes unitários
- [ ] Configurar um banco de dados real (MySQL, PostgreSQL, etc.)
- [ ] Adicionar camada de serviço
- [ ] Implementar uma API REST

## Dependências Principais

- JPA API 2.2
- Hibernate Core 5.6.15.Final
- H2 Database 2.1.214
- SLF4J + Logback para logs
- JUnit 4 para testes

## Licença

Este projeto faz parte do curso de Java da Holberton University.
