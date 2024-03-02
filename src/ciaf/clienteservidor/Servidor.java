package ciaf.clienteservidor;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int numThereads = 8;
        try {
            ServerSocket serverSocket = new ServerSocket(5000); // Puerto del servidor
            for (int i = 0; i < numThereads; i++) {
                while (true) {

                    Socket socket = serverSocket.accept(); // Espera por la conexión del cliente
                    System.out.println("Cliente conectado.");
                    ClienteHandler clienteHandler = new ClienteHandler(socket);
                    Thread clienteThread = new Thread(clienteHandler); // Inicia un nuevo hilo para el cliente
                    clienteThread.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}