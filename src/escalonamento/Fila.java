package escalonamento;

import java.util.ArrayList;

import node.Cliente;

public class Fila{

    public Cliente cabeca;
    public Cliente cauda;
    private double quilosCiclo;

    //------------------------------------------------------------------------------------------------Métodos

    public Cliente desenfileira(){
        Cliente retirado;
        if(this.filaVazia())retirado = null;
        else {
            retirado = this.cabeca;
            this.cabeca = this.cabeca.getProx();
        }
        return retirado;
    }

    public boolean enfileira(Cliente c){
        boolean inserido =  false;
        if(filaVazia()) {
            this.cabeca = c;
            this.cauda = c;
            inserido = true;
        }else {
            this.cauda.setProx(c);
            this.cauda = c;
            inserido = true;
        }
        return inserido;
    }

    public Cliente primeiro() {
        return cabeca;
    }
    public Cliente ultimo() {
        return cauda;
    }

    public void fazListaVazia(){
        cabeca.setProx(null);
        cabeca = null;
        cauda = null;
    }
    public String escrever() {
        String result = "";
        if(filaVazia()){
            result = "Lista Vazia!";
        }else {
            Cliente atual = this.cabeca;
            while(atual != null) {
                result += atual.toString() + " -> ";
                atual = atual.getProx();
            }
        }
        return result;
    }

    public boolean filaVazia(){
        boolean result = false;
        if(this.cabeca == null) result = true;
        return result;
    }
    //----------------------------------Calculo
    
    public void calculaTempo(ArrayList<Cliente> clientes, int quantCli){
    	int tempo = 1;
    	double pesoCiclo = 0;
    	double media = 0;
    	for(Cliente cli : clientes) {
    		this.enfileira(cli);
    	}
    	while(!this.filaVazia()) {
 
    		Cliente cli = this.desenfileira();
    		cli.setTempoPrimeiroLote(tempo);
    		pesoCiclo += cli.getPeso();
    		while(pesoCiclo >=35) {
    				tempo++;
        			pesoCiclo = pesoCiclo - 35;
    		}
    		cli.setTempoTodoLote(tempo);
    		 media += cli.getTempoTodoLote();
    		//System.out.println(cli.toString());
    	}
    	
    	
    	//System.out.println("\nFILA Tempo Total: "+tempo+" Horas\nTempo Médio por Cliente: " + (media/quantCli)+" Horas");
    
    }
    
    
}