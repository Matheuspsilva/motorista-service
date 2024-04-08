# motorista-service

## Visão Geral
O `motorista-service` é um microserviço Spring Boot projetado para gerenciar informações de motoristas. Ele oferece funcionalidades para criar, recuperar, atualizar e deletar dados de motoristas, e é integrado com sistemas de rastreamento distribuído e serviço de descoberta.

## Pré-requisitos
- Java 17
- Maven
- PostgreSQL
- Eureka Server
- Zipkin (para rastreamento distribuído)

## Configuração
1. **Banco de Dados**: Configure um banco de dados PostgreSQL. As credenciais e URL do banco devem ser configuradas no arquivo `application.yaml`.
2. **Eureka Server**: Certifique-se de que o Eureka Server está em execução e acessível.
3. **Zipkin**: Para rastreamento distribuído, configure e execute um servidor Zipkin.

## Instalação e Execução
1. Clone o repositório

```bash
git clone https://github.com/Matheuspsilva/motorista-service.git
```

2. Navegue até a pasta do projeto e execute:
    
```bash
mvn clean install
```

3. Para iniciar a aplicação, execute:
        
```bash
mvn spring-boot:run
```

## Swagger UI
A documentação da API REST está disponível através do Swagger UI. Após iniciar a aplicação, acesse http://localhost:8081/swagger-ui.html para visualizar e interagir com os endpoints da API.

## Monitoramento e Rastreamento
- Spring Boot Actuator: Fornece informações de saúde e métricas da aplicação. Acesse endpoints como /actuator/health para verificar o status da aplicação.
- Micrometer: Integrado para coleta de métricas. Configure destinos de exportação de métricas conforme necessário.
- Sleuth: Adiciona IDs de rastreamento em logs para facilitar o rastreamento de chamadas entre microserviços.
- Zipkin: Utilizado em conjunto com o Sleuth para visualizar rastreamentos. Certifique-se de que o servidor Zipkin está em execução e configurado corretamente em application.yaml.

## Endpoints da API
- GET /motoristas/{id}: Retorna um motorista pelo ID.
- GET /motoristas: Retorna todos os motoristas.
- POST /motoristas: Cria um novo motorista.
- PUT /motoristas/{id}: Atualiza um motorista existente.
- DELETE /motoristas/{id}: Deleta um motorista.
