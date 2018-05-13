package main;

import java.io.IOException;
import java.util.ArrayList;

import arquivo.Arquivo;
import escalonamento.*;
import node.Cliente;
import teclado.Teclado;

public class Main {

	public static void main(String[] args) throws Exception{
		Arquivo arq = new Arquivo();
		FilaPrioridade fp = new FilaPrioridade();
		Fila fila = new Fila();
		SJF sjf = new SJF();
		RoundRobin rr = new RoundRobin();
		
		try {
			arq.lerArquivo("lavanderia.txt");
			ArrayList<Cliente> clientes = arq.retornarClientes();
			int quantCli = arq.getQuantidadeCli();
			
			System.out.println("-----------------Lavanderia--------------------");
			System.out.println("Escolha o método de escalonamento: ");
			System.out.println("1-Fila\n2-Fila de Prioridade\n3-SJF\n4-RoundRobin");
			
			int opcao = Teclado.readInt();
			while(opcao < 1 || opcao > 4) {
				System.out.println("Opção inválida!\nDigite novamente:");
				opcao = Teclado.readInt();
			}
			
			switch(opcao) {
			
			case 1:
				fila.calculaTempo(clientes,quantCli);
				break;
			case 2:
				fp.calculaTempo(clientes,quantCli);
				break;
			case 3: 
				sjf.calculaTempo(clientes,quantCli);
				break;
			case 4:
				rr.calculaTempo(clientes,quantCli);
				break;
			}
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
