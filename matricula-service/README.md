# Matricula Service

## Inicializando o serviço
 - **Opção 1** *Localmente na maquina*: Execute o seguinte comando `mvn spring-boot:run` irá executar o serviço na porta 8080;
 - **Opção 2** *Usando em um container docker*: Execute os seguintes comando ` mvn clean install -U ` e ` docker-compose up --build `
 

## API Documentation
- **Rota Base** : http://localhost:8080
- **POST** /api/disciplina/create
   ```` 
       {
          "nome": "nomeString",
          "codigoDisciplina": "codigoString",
          "horario": "ABC",
          "turma": 1
        } 
- **POST** /api/estudantes/create 
  ````
        {
          "nome": "nomeAluno",
          "endereco": "Rua BlaBla",
          "documento": "1234"
        }
- **GET** /api/estudantes 
- **GET** /api/estudantes?nome=abc 
- **GET** /api/estudantes/123 
- **PUT** /api/estudantes/123 
- **DELETE** /api/estudantes/123 
- **DELETE** /api/estudantes/ALL 

- **POST** /api/matricula/create 
  ````
        {
          "matriculaEstudante": "abc",
          "codigoDisciplina": "ajsdlas",
          "turma": 1
        }
- **GET** /api/matricula/disciplinasByEstudante?matricula=123 
- **GET** /api/matricula/estudantesByDisciplina?codigoDisciplina=abc&turma=1 
