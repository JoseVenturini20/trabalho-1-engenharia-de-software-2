##API Documentation
`/api/disciplina/create POST`
  - body:
        {
          "nome": "nomeString",
          "codigoDisciplina": "codigoString",
          "horario": "ABC",
          "turma": 1
        } 

`/api/estudantes/create POST`
  - body:
        {
          "nome": "nomeAluno",
          "endereco": "Rua BlaBla",
          "documento": "1234"
        }
`/api/estudantes GET`
`/api/estudantes?nome=abc GET`
`/api/estudantes/123 GET`
`/api/estudantes/123 PUT`
`/api/estudantes/123 DELETE`
`/api/estudantes/ALL DELETE`

`/api/matricula/create POST`
  - body:
        {
          "matriculaEstudante": "abc",
          "codigoDisciplina": "ajsdlas",
          "turma": 1
        }
`/api/matricula/disciplinasByEstudante?matricula=123 GET`
`/api/matricula/estudantesByDisciplina?codigoDisciplina=abc&turma=1 GET`