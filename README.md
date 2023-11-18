## API Java REST de Gerenciamento de Vacinas
Este projeto é uma API Java REST que permite registrar, atualizar, listar e deletar vacinas. Ele utiliza o MongoDB como banco de dados para armazenar as informações das vacinas.

## Indice
- [Visão Geral](#visão-geral)
- [Requisitos](#requisitos)
- [Configuração do Ambiente ](#configuraçãodoambiente)
- [Uso](#uso)
- [Contribuição](#contribuição)
- [Autores](#autores)
- [Referências](#referências)

## Visão Geral

A api de Gerenciamento de Vacinas permite o registro, atualização, remoção e consulta de informações sobre as vacinas.

## As tecnologias principais utilizadas são:
- [Spring Boot](https://spring.io/projects/spring-boot/)
- [MongoDB](https://www.mongodb.com/pt-br)

## Requisitos
  - 1.Java 17 ou superior
  - 2.Maven 3.6.3 ou superior
  - 3.MongoDB 4.4.6 ou superior

    
## Configuração do Ambiente

## Instalação

- a. Clone este [repositório](https://github.com/daylane/Vacina.git) para o seu computador
- b. Abra o projeto no Intellij
- c. 	Configure as propriedades do aplicativo:
      •	Abra o arquivo application.properties no diretório src/main/resources.
      •	Ajuste as configurações do MongoDB conforme necessário.

## Uso

### A API possui os seguintes endpoints:

- GET /api/vacinas : Retorna uma lista de todas as vacinas cadastradas no banco de dados
- GET /api/vacinas/{id} : Retorna a vacina com o id especificado
- POST /api/vacina/registrarvacina : Cria uma nova vacina com os dados enviados no corpo da requisição
- PUT /api/vacina/atualizarVacina/{id} : Atualiza a vacina com o id especificado com os dados enviados no corpo da requisição
- DELETE /api/vacina/{id} : Deleta a vacina com o id especificado
O formato dos dados das vacinas é o seguinte:

- Post Exemplo de Resposta:
  {
    "id": "60a4b8c9f2d9c64f9c7f8a2c",
    "fabricante": "CoronaVac",
    "lote": "FJKDH45HF",
    "dataValidade":(LocalDate.of(2023,12,31),
    "numeroDoses": 2,
    "intervaloMininoEntreDoses": 28
  }
- Endpoint para deletar uma vacina por ID:

      Delete http: //localhost:8082/api/Vacinas/{ID}

- Delete Exemplo de resposta:

      Status: 204 No Content


- Endpoint para atualizar vacina por ID:

      PUT http: //localhost:8082/api/Vacinas/{ID}
         
- PUT exemplo de resposta:

  {
              "id": "60a4b8c9f2d9c64f9c7f8a2c",
              "fabricante": "CoronaVac",
              "lote": "FJKDH45HF",
              "dataValidade":(LocalDate.of(2023,12,31),
              "numeroDoses": 2,
              "intervaloMininoEntreDoses": 28}  
              
             }

## Autores
- [Felipe Santos](https://github.com/Lipe15)
- [Daylane Silva](https://github.com/daylane)
- [Gilson Marcos Paim](https://github.com/gilsongmptj)
- [Matheus Moura](https://github.com/mtcurly)
- [Felipe Olivera](https://github.com/fel1pee)
- [Marcus Vinicius](https://github.com/MarcusViniciusBtt)

##  Contribuição

Se desejar contribuir para o desenvolvimento deste projeto, siga estas etapas:

1. Crie um fork do repositório.
2. Crie uma branch com sua feature: `git checkout -b minha-feature`
3. Faça commit das alterações: `git commit -m 'Adicionando nova feature'`
4. Faça push para a branch: `git push origin minha-feature`
5. Envie um Pull Request.


##  Referências

- https://www.java.com/pt-BR
- https://www.mongodb.com/products/tools/compass
- https://spring.io/projects/spring-boot
- https://www.postman.com/

## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE] para mais detalhes.

# Espero que este README seja útil para o seu projeto. Se você tiver alguma dúvida ou sugestão, por favor, me avise. 😊
