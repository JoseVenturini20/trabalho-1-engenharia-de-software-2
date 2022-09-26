# Login Service

## Inicializando o serviço
 - **Opção 1** *Localmente na maquina*: Execute o seguinte comando `mvn spring-boot:run` irá executar o serviço na porta 8081;
 - **Opção 2** *Usando em um container docker*: Execute os seguintes comando ` mvn clean install -U ` e ` docker-compose up --build `irá executar o serviço na porta 8081.

## API Documentation
- **Rota Base** : http://localhost:8081
- **POST** /api/usuarios/registro 
  ````
        {
            "email": "email@email.com",
            "senha":"senha",
            "nome":"nome usuario"
        }
- **POST** /api/usuarios/login 
  ````
        {
            "email": "email@email.com",
            "senha": "senha"
        }
- **POST** /api/usuarios/logout 
  ````
        {
            "email": "email@email.com",
            "senha": "senha"
        }