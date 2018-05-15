package escalonamento;

import node.Cliente;

import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class RoundRobin{
    private Cliente cabeca;
    private Cliente cauda;
    
    public void enfileira(Cliente no){
        if(filaVazia()){
          this.cabeca = no;
          this.cauda = no;
        }else{
            boolean inserido = false;
            Cliente atual = cabeca;
            Cliente ant = new Cliente("null",0,0);
            while(!inserido){
              if(atual != cauda){
               ant = atual;  
               atual = atual.getProx();
               
              }else{
                atual.setProx(no);
                no.setProx(this.cabeca);
                this.cauda = no;
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
            if(this.cabeca.getProx() == this.cabeca)this.cabeca = new Cliente("null",0,0);
            else this.cabeca = this.cabeca.getProx();
            this.cauda.setProx(this.cabeca);
        }
        return result;
    }
    
    
    public boolean filaVazia(){
        boolean result = false;
        if(this.cabeca == null) result = true;
        return result;
    }
    
    public Cliente retiraNo(Cliente no){
    	Cliente result = new Cliente("null",0,0);
    	Cliente atual = this.cabeca;
    	Cliente ant = this.cauda;
      
      boolean retirado = false;
      while(!retirado){
        if(atual == no){
          result = atual;
          if(atual == this.cauda) {
        	  ant.setProx(atual.getProx());
        	  this.cauda = ant;
          }
          if(atual == this.cabeca){
            if(this.cauda == this.cabeca){ 
              this.cabeca = null;
              this.cauda = null; 
             }else{
               this.cabeca = atual.getProx();
               this.cauda.setProx(cabeca);
             } 
            
          }else ant.setProx(atual.getProx());
          retirado = true;
        }else{
          ant = atual;
          if(atual.getProx() != null)atual = atual.getProx();
          if(ant == cauda)retirado = true;
        }
      }
      
      return result;
    
    }
    
    public void calculaTempo(ArrayList<Cliente> clientes, int quantCli){
    	int tempo = 1;
    	double pesoCiclo = 0;
    	double media = 0;
    	int aux = 0;
    	for(Cliente cli : clientes) {
    		this.enfileira(cli);
    	}
    	Cliente cliente = this.cabeca;
    	while(!filaVazia()){
            if(cliente.getPeso() != 0){
                cliente.setPeso(cliente.getPeso() - 1);
                cliente = cliente.getProx();
                aux++;
            }else {
            	
            	cliente.setTempoTodoLote(tempo);
            	media += cliente.getTempoTodoLote();
            	if(cliente != null)this.retiraNo(cliente);
            	//System.out.println(cliente.toString());
            	cliente = cliente.getProx();
            }
            if(aux == 35) {
            	tempo++;
            	aux = 0;
            }
            
        }
    	//System.out.println("\nROUNDROBIN : Tempo Total: "+tempo+" Horas\nTempo Médio por Cliente: " + (media/quantCli)+" Horas");
    	
    
    }
    

}