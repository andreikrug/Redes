
import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    private ArrayList<String> lista = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String nome;

    public Lista(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void menu(int escolha) {

       // opcoes();
       // int escolha = sc.nextInt();

        while (escolha != 0) {
            switch (escolha) {
                case 1:
                    // mostrarLista();
                    //opcoes();
                    escolha = sc.nextInt();
                    break;

                case 2:
                    addTarefa();
                   // opcoes();
                    escolha = sc.nextInt();
                    break;

                case 3:
                    editaTarefa();
                    //opcoes();
                    escolha = sc.nextInt();
                    break;

                case 4:
                    completarTarefa();
                    //opcoes();
                    escolha = sc.nextInt();
                    break;

                case 5:
                    removerTarefa();
                   // opcoes();
                    escolha = sc.nextInt();
                    break;

                case 6:
                    limparLista();
                    //opcoes();
                    escolha = sc.nextInt();
                    break;

                case 7:
                    mudarNome();
                   // opcoes();
                    escolha = sc.nextInt();
                    break;

                default:
                    System.out.println("Essa não é uma opção disponível");
                    //opcoes();
                    escolha = sc.nextInt();
                    break;

            }
        }

    }

    String opcoes() {
        //System.out.println();
        //System.out.println("------------------------------- " + nome + " -----------------------------");
        //System.out.println("1) Mostrar lista");
        //System.out.println("2) Adicionar tarefa");
        //System.out.println("3) Editar tarefa");
       // System.out.println("4) Completar tarefa");
       // System.out.println("5) Remover tarefa");
       // System.out.println("6) Limpar a lista");
       // System.out.println("7) Mudar nome da lista");
        String val = ("0) Sair");
        //System.out.println("-------------- Digite 0 para sair de qualquer operação --------------");
        //System.out.println();
        return val;
    }

    public String mostrarLista() {
    	String val= "Default";
        for (int i = 0; i < lista.size(); i++) {
           val +=  (i + 1) + ". " + lista.get(i);
        }
        return val;
    }

    private void addTarefa() {
        System.out.println("Que tarefa deseja adicionar?");
        sc.nextLine();
        String tarefa = sc.nextLine();

        if (tarefa == "0") {
            return;
        }

        lista.add(tarefa);
    }

    private void editaTarefa() {
        System.out.println("Qual tarefa deseja editar? (digite o número da tarefa)");
        mostrarLista();
        int index = sc.nextInt() - 1;

        if (index == -1) {
            return;
        }

        while (index - 1 > lista.size()) {
            System.out.println("Digite um número válido");
            mostrarLista();
            index = sc.nextInt() - 1;
        }

        System.out.println("Como deve ser a tarefa? ");
        sc.nextLine();
        String tarefa = sc.nextLine();

        if (tarefa == "0") {
            return;
        }

        lista.set(index, tarefa);

    }

    private void completarTarefa() {
        System.out.println("Qual tarefa completou? (digite o número da tarefa)");
        mostrarLista();
        int index = sc.nextInt() - 1;

        if (index == -1) {
            return;
        }

        lista.set(index, (lista.get(index) + "(COMPLETADA)"));
    }

    private void removerTarefa() {
        System.out.println("Deseja remover qual tipo de tarefa?: ");
        System.out.println("1) Tarefas completadas");
        System.out.println("2) Outra tarefa");
        int esc = sc.nextInt();

        while(esc>2 || esc<0){
            System.out.println("Digite um número válido");
            System.out.println("1) Tarefas completadas");
            System.out.println("2) Outra tarefa");
            esc = sc.nextInt();
        }

        if (esc == 1) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).endsWith("(COMPLETADA)")) {
                    lista.remove(i);
                }
            }
        } else if (esc == 2) {
            System.out.println("Qual tarefa deseja remover? (digite o número da tarefa)");
            mostrarLista();
            int index = sc.nextInt() - 1;

            if (index == -1) {
                return;
            }

            lista.remove(index);
        } else if (esc==0) {
            return;
        }

    }

    private void limparLista() {
        System.out.println("Tem certeza que deseja limpar a lista? [S/N]");
        sc.nextLine();
        String resposta = sc.nextLine();

        if (resposta == "0") {
            return;
        }

        if (resposta.equalsIgnoreCase("S")) {
            lista.clear();
        }
    }

    private void mudarNome() {
        System.out.println("Qual o novo nome da lista? ");
        sc.nextLine();
        String novoNome = sc.nextLine();

        if (novoNome == "0") {
            return;
        }

        setNome(novoNome);
    }

}
