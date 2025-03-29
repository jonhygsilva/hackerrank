package com.coding.challenge.hackerrank;

import java.util.List;
import java.util.ArrayList;

public class EqualStacks {

    /**
     * Problema: Equal Stacks
     *
     * Dado três pilhas de inteiros h1, h2, e h3, o objetivo é igualar as alturas das três pilhas removendo elementos do topo
     * de cada pilha. Cada vez que removemos o topo de uma pilha, a altura da pilha diminui pelo valor do elemento removido.
     * O objetivo é encontrar a maior altura possível em que as três pilhas podem ter a mesma altura.
     *
     * A solução consiste em calcular a soma das alturas de cada pilha e em seguida remover o topo das pilhas que têm
     * maior altura, até que todas as pilhas possuam a mesma altura.
     *
     * Entrada:
     * - Três listas de inteiros, cada uma representando uma pilha de colunas.
     *
     * Saída:
     * - A altura máxima possível em que as três pilhas têm a mesma altura.
     *
     * Exemplo:
     * Se tivermos as pilhas:
     * h1 = [3, 2, 1, 1, 1]
     * h2 = [4, 3, 2]
     * h3 = [1, 1, 4, 1]
     *
     * A altura final será 5, pois todas as pilhas podem ser reduzidas a essa altura após remover certos elementos do topo.
     *
     * A abordagem consiste em ajustar as alturas das pilhas removendo elementos do topo da pilha com maior altura até que
     * todas as pilhas tenham a mesma altura.
     *
     * Restrição:
     * - A solução deve ser eficiente, minimizando as comparações e as operações de remoção de elementos.
     */

    // Função que gera a altura total de uma pilha somando os elementos
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Calculando a soma das pilhas inicialmente
        int sizeH1 = getSum(h1);
        int sizeH2 = getSum(h2);
        int sizeH3 = getSum(h3);

        // Índices para percorrer as pilhas
        int i1 = 0, i2 = 0, i3 = 0;

        // Enquanto as três pilhas não tiverem a mesma altura, removemos os elementos do topo
        while (sizeH1 != sizeH2 || sizeH2 != sizeH3) {
            // Remove o topo da pilha com maior altura
            if (sizeH1 >= sizeH2 && sizeH1 >= sizeH3) {
                sizeH1 -= h1.get(i1++);
            } else if (sizeH2 >= sizeH1 && sizeH2 >= sizeH3) {
                sizeH2 -= h2.get(i2++);
            } else {
                sizeH3 -= h3.get(i3++);
            }
        }

        // Quando as pilhas têm a mesma altura, retornamos a altura
        return sizeH1;
    }

    // Calcula a soma dos elementos de uma pilha
    public static int getSum(List<Integer> height) {
        return height.stream().mapToInt(Integer::intValue).sum();
    }

    // Exemplo de uso da classe
    public static void main(String[] args) {
        // Exemplo de pilhas
        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();

        // Adicionando elementos às pilhas
        h1.add(3);
        h1.add(2);
        h1.add(1);
        h1.add(1);
        h1.add(1);

        h2.add(4);
        h2.add(3);
        h2.add(2);

        h3.add(1);
        h3.add(1);
        h3.add(4);
        h3.add(1);

        // Chamando a função equalStacks para encontrar a altura máxima comum
        int result = equalStacks(h1, h2, h3);

        // Exibindo o resultado
        System.out.println("A maior altura possível para as pilhas é: " + result);
    }
}
