package Entites;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
             System.out.println("\n--- AGENDA ---");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Editar contato");
            System.out.println("4. Excluir contato");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                     System.out.println("Nome: ");
                     String nome = sc.nextLine();
                     System.out.println("Telefone: ");
                     String telefone = sc.nextLine();
                     System.out.println("Email: ");
                     String email = sc.nextLine();
                     agenda.adicionarContato(new Contato(nome, telefone, email));
                    break;
                case 2:
                    agenda.listarContatos();
                    break;
                case 3:
                    agenda.listarContatos();
                    System.out.print("Digite o número do contato a editar: ");
                    int idxEditar = sc.nextInt() - 1;
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();
                    System.out.print("Novo telefone: ");
                    telefone = sc.nextLine();
                    System.out.print("Novo email: ");
                    email = sc.nextLine();
                    agenda.editarContato(idxEditar, new Contato(nome, telefone, email));
                    break;
                case 4:
                    agenda.listarContatos();
                    System.out.print("Digite o número do contato a excluir: ");
                    int idxExcluir = sc.nextInt() - 1;
                    agenda.excluirContato(idxExcluir);
                    break;
                 case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                   System.out.println("Opção invalida.");
            }
        } while (opcao != 0);
        sc.close();
    }
}
