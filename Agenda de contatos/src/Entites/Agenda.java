package Entites;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {

    private List<Contato> contatos;
    private final String arquivo = "contatos.txt";

    public Agenda() {
        this.contatos = new ArrayList<>();
        carregarContatos();
    }

    public void adicionarContato(Contato c){
        contatos.add(c);
        salvarContatos();
    }

    public void listarContatos(){
        for(int i = 0; i < contatos.size(); i++){
           System.out.println((i+1) + " - " + contatos.get(i));
        }
    }

    public void excluirContato(int indice){
        if(indice >= 0 && indice <= contatos.size()){
            contatos.remove(indice);
            salvarContatos();
        } else {
            System.out.println("Indice invalido!");
        }
    }

    public void editarContato(int indice, Contato novo){
         if(indice >= 0 && indice <= contatos.size()){
            contatos.remove(indice);
            salvarContatos();
        } else {
            System.out.println("Indice invalido!");
        }        
    }

    public void salvarContatos(){
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))){
            for (Contato c : contatos){
                writer.println(c);
            }
        } catch (IOException e ) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarContatos() {
        try (Scanner sc = new Scanner(new File(arquivo))) {
            while (sc.hasNextLine()) {
                contatos.add(Contato.fromString(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado, iniciando nova agenda.");
        }
    }
    
}
