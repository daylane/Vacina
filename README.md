#VACINAÇÃO API
*Uma API Rest de Gestão de Vacinas*
  

1. Introdução
Esta é uma API de Gerenciamento de Vacinação que permite o controle e registro de vacinas, contendo dados como fabricante, lote da vacina , data de validade , número de doses a serem aplicadas e intervalos de dias entre as doses. A API foi desenvolvida para atender aos requisitos do projeto "Programação Web 2 - Oficial 2".

2. Conteúdo do README
Visão Geral
Requisitos
Configuração
Uso
Endpoints
Testes
Docker
Contribuição
Autores
Licença
Referências
3. Visão Geral
A API é projetada para fornecer as seguintes funcionalidades:

Registro de vacinações de pacientes.
Gerenciamento de informações sobre vacinas e pacientes.
Estatísticas sobre vacinação, como doses aplicadas, doses atrasadas e vacinas por fabricante.
4. Requisitos
Antes de iniciar, certifique-se de que possui os seguintes requisitos:

Java (versão 17)
MongoDBCompass
Postman

5. Configuração
Clone este repositório:
git clone https://github.com/daylane/Vacinacao.git
Instale as dependências:
Configure as variáveis de ambiente (por exemplo, em um arquivo .env) para definir as configurações do banco de dados, URLs de outras APIs, etc.
MONGODB_URI=mongodb://localhost:27017/vacinacao
API_PACIENTES_URL=http://localhost:xxx0.
API_VACINAS_URL=http://localhost:xxx1.
Inicie o servidor:
A API estará acessível em http://localhost:XXXX.
6. Uso
A API oferece vários endpoints para criar, ler, atualizar e excluir registros de vacinação, bem como para consultar informações estatísticas. Certifique-se de seguir a documentação dos endpoints.

7. Endpoints
/vacinas: Gerenciamento de informações sobre vacinas.
/pacientes: Gerenciamento de informações sobre pacientes.
/vacinacoes: Registro de vacinações de pacientes.
Consulte a documentação dos endpoints para obter detalhes sobre como usar cada um deles.

8. Testes
A API inclui testes automatizados para garantir o funcionamento correto dos endpoints. Execute os testes da seguinte maneira:


A API estará acessível em http://localhost:xxxx, e o banco de dados MongoDB estará em execução em ambiente local.

9. Contribuição
Se desejar contribuir para o desenvolvimento deste projeto, siga estas etapas:

Crie um fork do repositório.
Crie uma branch com sua feature: git checkout -b minha-feature
Faça commit das alterações: git commit -m 'Adicionando nova feature'
Faça push para a branch: git push origin minha-feature
Envie um Pull Request.

10. Autores
Daylane Silva - GitHub
Felipe Almeida - GitHub
Gilson Marcos Paim - GitHub

11. Licença
Este projeto é licenciado sob a Licença XYZ - consulte o arquivo LICENSE para obter detalhes.

12. Referências
-
-
-
-
