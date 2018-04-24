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
- Abstração para representar uma aresta em um grafo. Ela é útil para abstrairmos a lógica de fornecimento dos vértices que compõe determinada aresta. Além disso, torna mais fácil a manipulação, a ponto de utilizarmos uma List. Embora pudêssemos cogitar a possibilidade de uma estrutura de dicionário/hash, não seríamos capaz de ter um funcionamento apropriado no caso de um mapeamento chave-valor int->int, já que só podemos ter uma chave para cada número. Dessa forma, como vários vértices podem se relacionar entre si, teríamos que recorrer a um mapeamento chave-valor do tipo int->List<int>, que tornaria mais obscura a lógica da manipulação.

Classe Graph:
- Abstração para representar um grafo.

Classe RawGraph:
- Abstração para representar um grafo em seu estado bruto, ou seja, logo após ter sido lido do arquivo.

Classe GraphReader:
- Abstração para lidar com a leitura de um grafo a partir de um arquivo.

Classe GraphCreator:
- Abstração para lidar com a criação de um grafo a partir do que foi lido do arquivo. 

Classe GraphFomatter:
- Abstração para formatar a representação do grafo. Por exemplo, representar grafo como uma lista de adjacência ou matriz de adjacência seria tarefa dessa classe. Quem precisasse desse formato bastaria chamar o grafo;

- Todos os algoritmos que precisam do grafo em um formato específico usarão essa classe como provedora;

- Contribui para a coesão da leitura, pré-processamento e manipulação do grafo nos algoritmos.

Classe GraphOperator:
- Superclasse abstrata que servirá como abstração para os algoritmos em um grafo;

- Terá como subclasses as seguintes:
    - GraphSearcher: todos os algoritmos de busca e percurso em um grafo serão implementados aqui, por partilharem da característica de percurso pelos vértices e arestas;

    - GraphConnectivity: todos os algoritmos referentes à conectividade serão implementados aqui;
    
    - GraphTree: todos os algoritmos relativos às árvores (grafo acíclico e conectado) serão colocados aqui. Essa subclasse possui potencial para muitas outras subclasses, já que existem dezenas de tipos de árvores diferentes. Porém, para o escopo do problema em tela, não há necessidade disso. 