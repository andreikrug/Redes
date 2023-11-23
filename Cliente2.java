
import java.io.*;
import java.net.*;

public class Cliente2 {

	public static void main(String argv[]) throws Exception {
		boolean flag = true;
		while (flag) {
			String entrada;
			String respostaServ;

			BufferedReader doUsuario = new BufferedReader(new InputStreamReader(System.in));
			Socket socketCliente = new Socket("127.0.0.1", 6789);
			DataOutputStream paraServidor = new DataOutputStream(socketCliente.getOutputStream());
			BufferedReader doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

			respostaServ = doServidor.readLine();

			String[] x = respostaServ.split(";");
                for (String s : x) {
                    if (s != null) {
                        System.out.println(s);
                    }
                }
                System.out.println();

			/////////////// Escolha de opcao /////////////////////////////

			entrada = doUsuario.readLine();
			paraServidor.writeBytes(entrada + '\n');
			/////////////////////////////////////////////////////////////

			/////////////// Adicionar item /////////////////////////////
			if (entrada.equalsIgnoreCase("1")) {
				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				System.out.println(respostaServ);
				entrada = doUsuario.readLine();
				paraServidor.writeBytes(entrada + '\n');

				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				System.out.println(respostaServ);
				//////////////////////////////////////////////////////////////////////////////////////////


				/////////////// Mostrar lista /////////////////////////////
			} else if (entrada.equalsIgnoreCase("2")) {
				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();

				String[] lista = respostaServ.split(";");
                    for (String s : lista) {
                        if (s != null) {
                            System.out.println(s);
                        }
                    }
                    System.out.println();
			//////////////////////////////////////////////////////////////////////////////////////////


			/////////////// Remover Item /////////////////////////////
			}else if (entrada.equalsIgnoreCase("3")){
				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				System.out.println(respostaServ);

				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				
				String[] lista = respostaServ.split(";");
                    for (String s : lista) {
                        if (s != null) {
                            System.out.println(s);
                        }
                    }
                    System.out.println();

				entrada = doUsuario.readLine();
				paraServidor.writeBytes(entrada + '\n');

				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				System.out.println(respostaServ);
			//////////////////////////////////////////////////////////////////////////////////////////

			}else if (entrada.equalsIgnoreCase("0")){
				flag = false;
			} else if(entrada.equalsIgnoreCase("4")){
				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				System.out.println(respostaServ);

				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				
				String[] lista = respostaServ.split(";");
                    for (String s : lista) {
                        if (s != null) {
                            System.out.println(s);
                        }
                    }
                    System.out.println();

				entrada = doUsuario.readLine();
				paraServidor.writeBytes(entrada + '\n');

			} else if(entrada.equalsIgnoreCase("5")){
				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				System.out.println(respostaServ);

				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();

				
				String[] lista = respostaServ.split(";");
                    for (String s : lista) {
                        if (s != null) {
                            System.out.println(s);
                        }
                    }
                    System.out.println();

				entrada = doUsuario.readLine();
				paraServidor.writeBytes(entrada + '\n');

				doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				respostaServ = doServidor.readLine();
				System.out.println(respostaServ);
				entrada = doUsuario.readLine();
				paraServidor.writeBytes(entrada + '\n');

			}

			socketCliente.close();

		
	}
}
}
