# README - Sistema de Gerenciamento de Produtos

## Descrição do Projeto
Este é um sistema simples de gerenciamento de produtos desenvolvido em Java. Ele permite ao usuário cadastrar produtos de diferentes categorias, como bebidas, produtos alimentícios, produtos eletrônicos e produtos de vestuário. Além disso, o sistema permite exibir uma lista de produtos de cada categoria e todos os produtos cadastrados, bem como sair do programa. O sistema utiliza diversos conceitos de programação orientada a objetos e design patterns para garantir uma estrutura organizada e extensível.

## Funcionalidades
O sistema oferece as seguintes funcionalidades:
- Cadastro de Produtos: Permite ao usuário cadastrar produtos de diferentes categorias, como bebidas, produtos alimentícios, produtos eletrônicos e produtos de vestuário.
- Listagem de Produtos por Categoria: Permite ao usuário visualizar uma lista de produtos cadastrados em cada categoria.
- Listagem de Todos os Produtos: Exibe uma lista de todos os produtos cadastrados no sistema, independentemente da categoria.
- Saída do Programa: Permite ao usuário sair do programa de forma controlada.

## Estrutura do Projeto
O projeto é estruturado em várias classes Java, cada uma com uma responsabilidade específica:

1. **[Main](./src/main/java/andre/chamis/Main.java)**: Classe principal que inicia o programa, inicializando o menu.
2. **[Menu](./src/main/java/andre/chamis/application/menu/Menu.java)**: Classe responsável por exibir um menu de opções para o usuário e direcioná-lo para a opção selecionada.
3. **[OpcaoMenu](./src/main/java/andre/chamis/application/menu/OpcaoMenu.java)**: Enumeração que representa as opções do menu, cada uma associada a um objeto `Comando` que define a ação correspondente.
4. **[Comando](src/main/java/andre/chamis/application/comando)**: Interface que define um método `executar()`, implementada por classes de comando.
5. **[ProdutoComando](src/main/java/andre/chamis/application/comando/produto/ProdutoComando.java)**: Classe abstrata que implementa a interface Comando e fornece um campo para o serviço de produtos.
6. **[ProdutoService](./src/main/java/andre/chamis/services/ProdutoService.java)**: Singleton que fornece métodos para interagir com os produtos, como cadastrar, obter todos os produtos, etc.
7. **[RepositorioProduto](./src/main/java/andre/chamis/repo/RepositorioProduto.java)**: Classe responsável por armazenar os produtos em um mapa e fornecer métodos para acessá-los.
8. **[Produto](./src/main/java/andre/chamis/domain/produto/Produto.java)**: Classe abstrata que representa um produto com seus atributos básicos e métodos para imprimir detalhes e obter entrada do usuário.
9. **[InputUtils](./src/main/java/andre/chamis/utils/InputUtils.java)**: Classe utilitária que fornece métodos para obtenção de entrada do usuário.
10. **[StringUtils](./src/main/java/andre/chamis/utils/StringUtils.java)**: Classe utilitária que fornece métodos para manipulação de strings.

## Design Patterns Utilizados
O projeto faz uso dos seguintes design patterns:

1. **Singleton**: Utilizado na classe [ProdutoService](./src/main/java/andre/chamis/services/ProdutoService.java) para garantir que apenas uma instância do serviço de produtos seja criada durante a execução do programa.

2. **Command**: O padrão Command é empregado nas classes relacionadas aos comandos do menu. A interface [Comando](src/main/java/andre/chamis/application/comando) define um método `executar()`, que é implementado por diversas classes de comando, permitindo encapsular as ações do usuário em objetos independentes.

3. **Factory Method**: Embora não explicitamente implementado nas classes fornecidas, o método `fromInput()` em algumas classes pode ser considerado uma implementação simplificada do padrão Factory Method, permitindo a criação de instâncias de produtos com base na entrada do usuário.

4. **Strategy**: A enumeração [OpcaoMenu](./src/main/java/andre/chamis/application/menu/OpcaoMenu.java) pode ser vista como uma implementação simplificada do padrão Strategy. Cada constante na enumeração representa uma opção do menu, e cada opção possui uma estratégia associada na forma de um objeto [Comando](src/main/java/andre/chamis/application/comando). Isso permite a seleção dinâmica de comportamentos em tempo de execução, sem a necessidade de detalhes de implementação específicos no código que chama as opções do menu.


Este README fornece uma visão geral do sistema de gerenciamento de produtos e destaca os design patterns utilizados. Para mais detalhes sobre implementações específicas e outras considerações de design, consulte o código-fonte fornecido.
