<h1 align="center">
  API de Clima
</h1>

## Descrição
Projeto com Integração com a API externa WeatherStack para obter dados meteorológicos em tempo real, incluindo informações sobre a cidade, região, país, temperatura, fuso horário e horário local.

## Tecnologias
- Java
- Spring Boot
- Maven
- H2 Database
- JUnit e Mockito
- Spring Cache
- Mapstruct
- Lombok

## Endpoint

`GET /api/v1/weather/{city}`

Este endpoint retorna as informações meteorológicas da cidade:

```json
{
  "city": "San Paulo",
  "region": "Sao Paulo",
  "country": "Brazil",
  "temperature": 22,
  "timezoneId": "America/Sao_Paulo",
  "localtime": "2025-05-10 14:09"
}
```

## Configuração e Execução
Pré-requisitos: Java 17 e Maven

1. clone o repositório
2. acesse o diretório do projeto
3. adicione a API Key da sua conta da Weatherstack no application.properties

```bash
# instale as dependências do Maven
mvn clean install

# execute a aplicação
mvn spring-boot:run

# pressione (ctrl + c) para encerrar a aplicação
```

## Autor

- Projeto desenvolvido por [Isabel Henrique](https://www.linkedin.com/in/isabel-henrique/)
- Fique à vontade para contribuir!