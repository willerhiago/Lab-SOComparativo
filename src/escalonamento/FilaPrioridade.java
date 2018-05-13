package escalonamento;

import java.util.ArrayList;

import node.Cliente;

public class FilaPrioridade{
    private Cliente cabeca;
    
    public void enfileira(Cliente no){
        if(filaVazia())this.cabeca = no;
        else{
            boolean inserido = false;
            Cliente atual = cabeca;
            Cliente ant = new Cliente("null",0,0);
            while(!inserido){
                if(atual != null && no.getPreco() < atual.getPreco() ){
                 
                 ant = atual;  
                 if(atual.getProx() == cabeca){
                    atual.setProx(no);
                    inserido = true;
                    
                 }
                 atual = atual.getProx();
                 
                }else{
                    ant.setProx(no);
                    no.setProx(atual);
                    if(atual == cabeca)this.cabeca = no;
                    inserido = true;
                }                                
            }
            
            
        }
        
    }
    
    public Cliente desenfileira(){
    	Cliente result = new Cliente("null",0,0);
        if(filaVazia())System.out.println("Fila vazia!");
        else{
            result = this.cabeca;
            this.cabeca = this.cabeca.getProx();
        }
        
        return result;
    }
    
    
    public boolean filaVazia(){
        boolean result = false;
        if(this.cabeca == null) result = true;
        return result;
    }
    
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
    		System.out.println(cli.toString());
    	}
    	
    	
    	System.out.println("\nFILA DE PRIORIDADE  Tempo Total: "+tempo+" Horas\nTempo Médio por Cliente: " + (media/quantCli)+" Horas");
    
    }
    
    
}