import java.util.Random;

public class TabelaHashEncadeada {

    static class No {
        int valor;
        No proximo;
    }

    public static void main(String[] args) {
        int tamanhoTabela = 100;
        int quantidadeInsercoes = 1000;
        No[] tabela = new No[tamanhoTabela];

        Random aleatorio = new Random(1090);

        int antepenultimo = 0;
        int penultimo = 0;
        int ultimo = 0;
        int inseridosNaLista = 0;

        for (int i = 0; i < quantidadeInsercoes; i++) {
            int numero = aleatorio.nextInt(100001);
            int posicao = numero % tamanhoTabela;

            No novo = new No();
            novo.valor = numero;
            novo.proximo = null;

            if (tabela[posicao] == null) {
                tabela[posicao] = novo;
            } else {
                No atual = tabela[posicao];
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novo;

                if (inseridosNaLista == 0) {
                    antepenultimo = numero;
                } else if (inseridosNaLista == 1) {
                    penultimo = numero;
                } else if (inseridosNaLista == 2) {
                    ultimo = numero;
                } else {
                    antepenultimo = penultimo;
                    penultimo = ultimo;
                    ultimo = numero;
                }
                inseridosNaLista = inseridosNaLista + 1;
            }
        }

        int quantidadeListas = 0;
        int posicoesVazias = 0;
        int maiorTamanho = 0;
        int posicaoMaior = -1;

        for (int i = 0; i < tamanhoTabela; i++) {
            if (tabela[i] == null) {
                posicoesVazias = posicoesVazias + 1;
            } else {
                int tamanhoLista = 0;
                No atual = tabela[i];
                while (atual != null) {
                    tamanhoLista = tamanhoLista + 1;
                    atual = atual.proximo;
                }

                if (tamanhoLista > 1) {
                    quantidadeListas = quantidadeListas + 1;
                }

                if (tamanhoLista > maiorTamanho) {
                    maiorTamanho = tamanhoLista;
                    posicaoMaior = i;
                }
            }
        }

        System.out.println("Maior lista encadeada:");
        System.out.println("Posicao: " + posicaoMaior);
        System.out.println("Tamanho: " + maiorTamanho);

        No atual = tabela[posicaoMaior];
        while (atual != null) {
            System.out.print(atual.valor);
            if (atual.proximo != null) {
                System.out.print(" -> ");
            }
            atual = atual.proximo;
        }
        System.out.println();

        System.out.println("Listas encadeadas geradas: " + quantidadeListas);
        System.out.println("Posicoes vazias: " + posicoesVazias);

        System.out.println("Tres ultimos valores inseridos em listas encadeadas:");
        if (inseridosNaLista == 0) {
            System.out.println("Nenhum valor foi inserido em lista encadeada.");
        } else if (inseridosNaLista == 1) {
            System.out.println(antepenultimo);
        } else if (inseridosNaLista == 2) {
            System.out.println(antepenultimo);
            System.out.println(penultimo);
        } else {
            System.out.println(antepenultimo);
            System.out.println(penultimo);
            System.out.println(ultimo);
        }
    }
}
