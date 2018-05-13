package node;

public class Roupa {


    private Roupa prox;
    private int prioridade;
    private double peso;
    private double preco;

    public Roupa(Roupa prox, int prioridade, double peso, double preco) {
        this.prox = prox;
        this.prioridade = prioridade;
        this.peso = peso;
        this.preco = preco;
    }

    public Roupa getProx() {
        return prox;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public double getPeso() {
        return peso;
    }

    public double getPreco() {
        return preco;
    }

}
