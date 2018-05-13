package arquivo;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import node.Cliente;

public class Arquivo {

    private FileInputStream arqEntrada;
    private DataInputStream entrada;
    private String arquivo;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private int quantidadeCli;


    //-------------------------------------Métodos sobre arquivo
    private void abreArquivo(String nomeArquivo) throws FileNotFoundException {
        if(nomeArquivo == null || nomeArquivo == "") {
            this.arqEntrada = new FileInputStream("lavanderia");
            this.arquivo = nomeArquivo;
        }
        else {
            this.arqEntrada = new FileInputStream(nomeArquivo);
            this.arquivo = nomeArquivo;
        }

        this.entrada = new DataInputStream(arqEntrada);
    }

    private void fechaArquivo() throws IOException {
        entrada.close();
        arqEntrada.close();
    }

    //------------------------------M�todos lavanderia

    public void lerArquivo(String arquivo) throws NumberFormatException, IOException {
        this.abreArquivo(arquivo);
        String teste = entrada.readLine();
        quantidadeCli = Integer.parseInt(teste);

        while(entrada.available() != 0){
        	String[] cliente = entrada.readLine().split(";");
        	Cliente cli = new Cliente(cliente[0], Integer.parseInt(cliente[1]), Double.parseDouble(cliente[2].replace(",", ".")));
            clientes.add(cli);
        }

        this.fechaArquivo();


    }
    public void escreverClientes() {
        if(quantidadeCli == 0) System.out.println("Não há clientes");
        else {
            for(Cliente c : clientes){
                System.out.println(c.toString());
            }
        }
    }

    public ArrayList<Cliente> retornarClientes() {
        return this.clientes;
    }
    
    public int getQuantidadeCli() {
    	return this.quantidadeCli;
    } 
}
