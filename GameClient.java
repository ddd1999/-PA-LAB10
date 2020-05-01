package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Cu Scanner preiau comenzile de la tastatura.
 * Adresa si portul serverului sunt locale.
 * In while se verifica, constant, daca se primeste o comanda de la tastatura si in functie de request rezulta un raspuns
 * In cazul in care comada este "exit" sau "stop", serverul se opreste
 */
public class GameClient {
        public static void main (String[] args) throws IOException {
            String serverAddress = "127.0.0.1";
            int PORT = 8100;
            try (
                    Socket socket = new Socket(serverAddress, PORT);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream())) ) {
                while(true) {
                    Scanner cmd = new Scanner(System.in);
                    System.out.println("Enter the command:");
                    String command = cmd.nextLine();
                    if (command.equals("exit")) {
                        out.println(command);
                        break;
                    }
                    out.println(command);
                    String response = in.readLine();
                    out.println(response);
                    if(response.equals("Server stopped."))
                    {
                        break;
                    }
                }
            } catch (UnknownHostException e) {
                System.err.println("No server listening... " + e);
            }
        }
    }

