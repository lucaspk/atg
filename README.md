# Aplicação de Teoria dos Grafos

Repositório dedicado às implementações relativas à disciplina em questão.

## Direcionamentos para criação de casos de testes

### Testes Funcionais
Testes funcionais, ou de caixa preta (tem esse nome porque não leva em conta a implementação, tratando-a como uma caixa preta), são voltados à verificar e validar a especificação.

#### Técnicas
Temos algumas técnicas para testar a especificação:

- Análise do Valor Limite (AVL): se a variável possui valor limite, testar ela neles e próximo a eles. Testar em: (mínimo, mínimo + 1) e (máximo - 1, máximo). Usar apenas quando as variáveis forem independentes;

- Teste de Robustez: valores fora dos limites, ou seja, acima do maior e abaixo do menor. Reune os casos de AVL. Em outras palavras: (mínimo - 1, mínimo, mínimo + 1) e (máximo - 1, máximo, máximo + 1);

- Teste do Pior Caso: pior caso das variáveis;

- Teste de Valores Especiais: letra ou caractere especial ao invés de número etc.

Existem outras técnicas, tais como as relativas à partição por equivalência (fraca, robusta fraca, forte e robusta forte) que ajudam a minimizar redundância de casos de testes, mas não vêm ao caso.

### Testes Estruturais
Testes estruturais, ou de caixa branca, verificam e validam a implementação em si.

#### Critérios de cobertura
Dentro de testes funcionais temos o conceito de cobertura, que diz respeito à porcentagem de quanto do nosso código foi executado.

Tem-se alguns tipos de cobertura, sendo as mais comuns estas:
- Cobertura de linha/instrução: tipo de cobertura que olha para cada linha e constata se ela foi alcançada alguma vez;

- Cobertura de ramo: pensando no código como um grafo de instruções, um ramo seria um subgrafo, e portanto, esse tipo de cobertura avalia se subgrafos foram exercitados;

- Cobertura de caminho: esse tipo de cobertura nos fornece a maior confiança sobre funcionamento, já que, pensando no código como um grafo, avaliamos todos os caminhos possíveis para a execução. Como percorrer todos os caminhos implica passar por todos os ramos e nós (instruções), esse tipo de cobertura garante os outros supracitados.
