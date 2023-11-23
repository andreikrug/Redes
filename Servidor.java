import java.io.*;
import java.net.*;
import java.util.ArrayList;

class Servidor {
    public static void main(String argv[]) throws Exception {

        ArrayList<String> tarefas = new ArrayList<>();

        ServerSocket socketRecepcao = new ServerSocket(6789);

        while (true) {
            Socket socketConexao = socketRecepcao.accept();
            // Inicia uma nova thread para tratar a conexão
            new Thread(new ClienteHandler(socketConexao, tarefas)).start();
            
        }
    }
}

class ClienteHandler implements Runnable {
    private Socket socketConexao;
    private ArrayList<String> tarefas;
  

    public ClienteHandler(Socket socketConexao, ArrayList<String> tarefas) {
        this.socketConexao = socketConexao;
        this.tarefas = tarefas;
    }

    @Override
    public void run() {
        try {
            BufferedReader doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
            DataOutputStream paraCliente = new DataOutputStream(socketConexao.getOutputStream());

            paraCliente.writeBytes("1) Adicionar item na lista;2) Mostrar lista;3) Remover item da lista;4) Marcar concluida; 5) para atribuir tecnico; 0) Sair da aplicacao" + '\n');

            String resposta = doCliente.readLine();

            if (resposta.equalsIgnoreCase("1")) {
                doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
                paraCliente = new DataOutputStream(socketConexao.getOutputStream());
                paraCliente.writeBytes("Digite a nova tarefa:" + '\n');
                resposta = doCliente.readLine();

                tarefas.add(resposta);
                paraCliente.writeBytes(tarefas.get(tarefas.size() - 1) + " foi adicionada a lista"+'\n');

            } else if (resposta.equalsIgnoreCase("2")) {
                doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
                paraCliente = new DataOutputStream(socketConexao.getOutputStream());

                String itens = "";
                for (int i = 0; i < tarefas.size(); i++) {
                    itens += (i + 1) + ". " + tarefas.get(i) + ";";
                }

                paraCliente.writeBytes(itens + '\n');

            } else if (resposta.equalsIgnoreCase("3")) {
                doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
                paraCliente = new DataOutputStream(socketConexao.getOutputStream());
                paraCliente.writeBytes("Digite o numero da tarefa para ser removida:" + '\n');
                String itens = "";
                for (int i = 0; i < tarefas.size(); i++) {
                    itens += (i + 1) + ". " + tarefas.get(i) + ";";
                }

                paraCliente.writeBytes(itens + '\n');
                resposta = doCliente.readLine();

                int index = Integer.valueOf(resposta);

                String tarefaRemovida = tarefas.get(index - 1);
                tarefas.remove(index - 1);

                paraCliente.writeBytes("A tarefa: " + tarefaRemovida + " foi removida" + '\n');
            } else if(resposta.equalsIgnoreCase("4")){

                doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
                paraCliente = new DataOutputStream(socketConexao.getOutputStream());
                paraCliente.writeBytes("Digite o numero da tarefa para ser marcada como concluida:" + '\n');
                 String itens = "";
                for (int i = 0; i < tarefas.size(); i++) {
                    itens += (i + 1) + ". " + tarefas.get(i) + ";";
                }

                paraCliente.writeBytes(itens + '\n');
                resposta = doCliente.readLine();

                int index = Integer.valueOf(resposta);

                tarefas.set(index -1, tarefas.get(index -1) + "  ||||| Status: Concluida  |||||");

            } else if(resposta.equalsIgnoreCase("5"))
            {
                // para atribuir o nome na tarefa
                doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
                paraCliente = new DataOutputStream(socketConexao.getOutputStream());
                paraCliente.writeBytes("Digite o numero da tarefa para ser atribuida:" + '\n');
                String itens = "";
                for (int i = 0; i < tarefas.size(); i++) {
                    itens += (i + 1) + ". " + tarefas.get(i) + ";";
                }

                paraCliente.writeBytes(itens + '\n');
                resposta = doCliente.readLine();
                int index = Integer.valueOf(resposta);

                doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
                paraCliente = new DataOutputStream(socketConexao.getOutputStream());
                paraCliente.writeBytes("Digite o nome para ser atribuido:" + '\n');
                resposta = doCliente.readLine();
                if(tarefas.get(index-1).contains("---"))
                {

                }
                tarefas.set(index -1, tarefas.get(index -1) + " ||||| Tecnico: "+ resposta + " ||||");
            }

            // Fecha a conexão após a comunicação
            socketConexao.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
