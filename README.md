# dextra-food
Projeto teste para a Dextra

Este projeto foi feito usando Spring boot e jQurery + HTML.
O Spring Boot foi escolhido como framework por oferecer auto configuração e
um paradigma MVC, onde as tarefas são bem separadas entre controllers (no caso, resources),
que oferecem acesso à api, services, que contém as regras de negócio, repositories, que oferecem
acesso aos objetos no banco de dados, e as classes de dados em si. O Spring Boot também tem a grande
vantagem de ter servers embarcados, além de ser o framework no qual o autor tem maior experiência.

O projeto contém duas classes de dados: os ingredientes (Ingredients) e os sanduíches (Sandwiches).
Estas são ligadas por uma relação many to many que contém uma coluna extra, a coluna de quantidade,
que indica a quantidade de um determinado ingrediente em um sanduíche. Isso facilita a construção de 
sanduíches sem duplicar ingredientes, além facilitar uma possível implementação de busca de sanduíches
por ingredientes.

Repositórios JPA foram usados para acesso ao banco, ao invés de DAOs com implementação de sessões do
Hibernate. Essa escolha foi feita porque esses repositórios oferecem uma boa implementação das queries
mais básicas, e adicionam pouco overhead de implementação.

Para os testes unitários, foram utilizados o jUnit, o Mockito e o mockMVC. O jUnit e o Mockito
são ferramentas muito conhecidas e utilizadas no mercado, e oferecem uma facilidade muito grande na hora
de implementar testes. O mockMVC é muito eficiente para testar controllers e endpoints, oferecendo formas de
testar headers e bodies de requisições.

Para a hospedagem, foram utilizadas duas máquinas EC2 na AWS, uma t2.micro e uma t2.small. O proxying do server
foi feito com o nginx, como requisitado, e a conteinerização do jar gerado pelo projeto foi feita com o docker.
O ambiente de CI foi feito com jenkins, e pode ser acessado em:
http://ec2-34-217-52-65.us-west-2.compute.amazonaws.com:8080
As credencias serão enviadas por e-mail.


Front End

O front end foi feito usando jQuery e HTML, como requisitado. Um plugin de cart, o jquery-smartcart, foi utilizado
para fazer o carrinho. O bootstrap foi utilizado como template para o html. Nenhuma ferramenta de build, como gulp,
webpack ou grunt foi utilizada por não fazer parte dos requisitos, e porque o projeto do front-end é muito simples.
Adicionando-se novas features, ou se alguma forma a complexidade do projeto aumentar, a utilização de uma dessas ferramentas
se faz muito necessára.

Instruções para executar:

Opção 1: Importar o projeto no IntelliJ como Maven Project, criar uma configuração de execução(Run/Debug) do tipo Spring Boot utilizando a classe
com.dextra.fastfood.FastfoodApplication como Main class. Essa configuração provavelmente será gerada automaticamente pelo IntelliJ.

Opção 2: Fazer download da imagem do projeto e rodar com o Docker. Comandos:
docker pull hrss/dextra-food
docker run --rm -d -p {porta favorita}:8080 --name dextra-food hrss/dextra-food

Opção 3:
Acessar http://ec2-54-70-206-52.us-west-2.compute.amazonaws.com/
You're good to go!
