# Login Service

## Inicializando o serviço
 `mvn spring-boot:run` irá executar o serviço na porta 8081;

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