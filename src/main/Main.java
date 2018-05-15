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
		
		long inicio;
		long fim;
		long[] tempos = new long[100];
		long media = 0;
		
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
				for(int i = 0; i < 100; i ++) {
					inicio = System.currentTimeMillis();
					fila.calculaTempo(clientes,quantCli);
					fim = System.currentTimeMillis();
					tempos[i] = (fim-inicio);
				}
				media = calculaMedia(tempos,100);
				System.out.println("Tempo: "+ media);
				break;
			case 2:
				
				for(int i = 0; i < 100; i ++) {
					inicio = System.currentTimeMillis();
					fp.calculaTempo(clientes,quantCli);
					fim = System.currentTimeMillis();
					tempos[i] = (fim-inicio);
				}
				media = calculaMedia(tempos,100);
				System.out.println("Tempo: "+ media);
				break;
			case 3: 
				for(int i = 0; i < 3; i ++) {
					inicio = System.currentTimeMillis();
					sjf.calculaTempo(clientes,quantCli);
					fim = System.currentTimeMillis();
					tempos[i] = (fim-inicio);
				}
				media = calculaMedia(tempos,100);
				System.out.println("Tempo: "+ media);
				break;
			case 4:
				for(int i = 0; i < 100; i ++) {
					inicio = System.currentTimeMillis();
					rr.calculaTempo(clientes,quantCli);
					fim = System.currentTimeMillis();
					tempos[i] = (fim-inicio);
				}
				media = calculaMedia(tempos,100);
				System.out.println("Tempo: "+ media);
				break;
			}
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static long calculaMedia(long[] valores, int n) {
		long soma = 0;
		for(int i =0;i<n;i++) {
			soma += valores[i];
		}
		long result = (soma/n);
		return result;		
		
	}

}
