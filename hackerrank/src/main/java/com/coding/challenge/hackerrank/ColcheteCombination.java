package com.coding.challenge.hackerrank;

import java.util.ArrayList;

class ColcheteCombination {

    /**
     * Problema: Gere todas as combinações válidas de n pares de colchetes balanceados "{}".
     *
     * Um conjunto de colchetes é considerado balanceado se:
     * - Para cada colchete de abertura "{", existe um correspondente colchete de fechamento "}".
     * - Nenhum colchete de fechamento "}" aparece antes do correspondente colchete de abertura "{".
     *
     * Entrada:
     * - Um inteiro n que representa o número de pares de colchetes.
     *
     * Saída:
     * - Uma lista contendo todas as combinações possíveis de n pares de colchetes balanceados.
     *
     * Exemplo:
     * Para n = 3, as combinações possíveis são:
     * {{{
     * {{}}
     * {{}}{}
     * {}{{}}
     * {}{}{}
     *
     * Restrições:
     * - O número de colchetes fechados não pode ser maior que o número de abertos em qualquer ponto.
     */

    // Função que gera todas as combinações balanceadas de colchetes
    public static void generateParenthesis(int n, int open, int close, String s, ArrayList<String> ans) {
        // Quando o número de colchetes abertos e fechados alcança `n`, adiciona a combinação à lista
        if (open == n && close == n) {
            ans.add(s);
            return;
        }

        // Adiciona um colchete aberto se ainda houver espaço para mais
        if (open < n) {
            generateParenthesis(n, open + 1, close, s + "{", ans);
        }

        // Adiciona um colchete fechado se o número de colchetes fechados for menor que o de abertos
        if (close < open) {
            generateParenthesis(n, open, close + 1, s + "}", ans);
        }
    }

    public static void main(String[] args) {
        int n = 6; // Número de pares de colchetes

        ArrayList<String> ans = new ArrayList<>();

        // Gera todas as combinações de colchetes balanceados
        generateParenthesis(n, 0, 0, "", ans);

        // Exibe os resultados
        System.out.println("Combinações de colchetes balanceados para n = " + n + ":");
        for (String combination : ans) {
            System.out.println(combination);
        }
    }
}
