package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Verific daca primesc vreo comanda.
 * In cazul in care comanda este contine "stop", serverul se opreste si se afiseaza mesajul ca serverul s-a oprit.
 * In cazul in care comanda este "exit", clientul se opreste.
 */
public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            while(true){
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String response = "Server stopped.";
            if(request.startsWith("stop")) {
                out.println(response);
                out.flush();
                in.close();
                socket.close();
            }
            else if(request.equals("exit")) { break; }
            else {
                out.println("Server received the request ... " + request);
                out.flush();
            }
            }
        } catch (IOException e) {
            System.err.println( "Error: " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }
}
