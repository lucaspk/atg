# Decisões de design e implementação

## Descrição alto-nível do funcionamento de criação de um grafo

- GraphReader lê os números do arquivo txt e transforma em um RawGraph, que conterá esses valores em formato de List de String;

- Em seguida, GraphCreator trata a lista citada para produzir uma List de Edge usada na criação do objeto Graph, o qual será retornado pelo método de criação.

Exemplo com código:

```java
String filePath = "src\\sample_graph.txt";

Graph graph = GraphCreator.createGraph(filePath);
```
 

## Design da Aplicação

Foi seguido o Princípio de Responsabilidade Única que, segundo Robert C. Martin (Uncle Bob), autor do livro Clean Code, significa que uma entidade possui apenas UMA razão para mudar. Assim sendo, responsabilidade significa razão para mudar. Por exemplo, a classe GraphReader possui apenas uma razão para mudar, que diz respeito à alteração na leitura de um grafo a partir do arquivo. Do mesmo modo a classe GraphCreator, cuja única razão para mudar diz respeito às mudanças relativas à criação de um grafo. Essa lógica se aplica às outras.

### Entidades criadas

Classe Edge:
- Abstração, nesse caso, um POJO - Plain Old Java Object - que tende a seguir o padrão JavaBean(não há nada de especial além dos getters e setters) para representar uma aresta em um grafo. Ela é útil para abstrairmos a lógica de fornecimento dos vértices que compõe determinada aresta. Além disso, torna mais fácil a manipulação em uma estrutura de dados.

Classe Graph:
- Abstração para representar um grafo.

Classe RawGraph:
- Abstração para representar um grafo em seu estado bruto, ou seja, logo após ter sido lido do arquivo. Ele vai servir para encapsular a criação de um grafo tendo em vista que o que temos no início é uma lista de strings. Como estamos preocupados com o princípio da responsabilidade única, uma classe deve fazer apenas uma coisa. Ou seja, a leitura é diferente do processamento do que foi lido. Por essa razão, RawGraph foi criado.

Classe GraphReader:
- Abstração para lidar com a leitura de um grafo a partir de um arquivo.

Classe GraphCreator:
- Abstração para lidar com a criação de um grafo a partir do que foi lido do arquivo tomando como base o processamento da classe RawGraph. 

Classe GraphFomatter:
- Abstração para formatar a representação do grafo. Por exemplo, representar grafo como uma lista de adjacência ou matriz de adjacência seria tarefa dessa classe. 

Classe GraphSearcher: 
- Todos os algoritmos de busca e percurso em um grafo serão implementados aqui, por partilharem da característica de percurso pelos vértices e arestas.

GraphConnectivity: 
- Todos os algoritmos referentes à conectividade serão implementados aqui(connected e shortestpath).

GraphTree: 
- Todos os algoritmos relativos às árvores (grafo acíclico e conectado) serão colocados aqui. Essa subclasse possui potencial para muitas outras subclasses, já que existem dezenas de tipos de árvores diferentes. Porém, para o escopo do problema em tela, abrigará apenas MST(Minning Spinning Tree). 

VertexInfo:
- Abstração para representar o predecessor e a distância de modo a tornar possível o algoritmo de MST.
