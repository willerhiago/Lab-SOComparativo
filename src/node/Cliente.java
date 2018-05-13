package node;

public class Cliente {

    String nome;
    int peso;
    double preco;
    Cliente prox;
    Cliente ant;
    double tempoPrimeiroLote;
    double tempoTodoLote;
    
    public Cliente(String nome,int peso,double preco){
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public Cliente(String nome,int peso,double preco, int tempso_recebimento){
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public String toString() {
        return getNome() + ";" + getPeso() + ";" + getPreco() + " || Primeiro lote: " + getTempoPrimeiroLote() + " || Todo lote: " + getTempoTodoLote() ;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }


    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }


    public Cliente getProx() {
        return prox;
    }

    public void setProx(Cliente prox) {
        this.prox = prox;
    }



    public Cliente getAnt() {
        return ant;
    }


    public void setAnt(Cliente ant) {
        this.ant = ant;
    }

	public double getTempoPrimeiroLote() {
		return tempoPrimeiroLote;
	}

	public void setTempoPrimeiroLote(double tempoPrimeiroLote) {
		this.tempoPrimeiroLote = tempoPrimeiroLote;
	}

	public double getTempoTodoLote() {
		return tempoTodoLote;
	}

	public void setTempoTodoLote(double tempoTodoLote) {
		this.tempoTodoLote = tempoTodoLote;
	}



}
