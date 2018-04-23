# Decisões de design e implementação

Classe Edge:
- Abstração para representar uma aresta em um grafo. Ela é útil para abstrairmos a lógica de fornecimento dos vértices que compõe determinada aresta. Além disso, torna mais fácil a manipulação, a ponto de utilizarmos uma List. Embora pudêssemos cogitar a possibilidade de uma estrutura de dicionário/hash, não seríamos capaz de ter um funcionamento apropriado no caso de um mapeamento chave-valor int->int, já que só podemos ter uma chave para cada número. Dessa forma, como vários vértices podem se relacionar entre si, teríamos que recorrer a um mapeamento chave-valor do tipo int->List<int>, que tornaria mais obscura a lógica da manipulação.

Classe Graph:
- Abstração para representar um grafo. Ela contém o mapeamento de um vértice para outro, já que, por padrão, um arquivo representando um grafo separa eles por espaço em branco.

Classe GraphReader:
- Abstração para lidar com a leitura de um grafo a partir de um arquivo.

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