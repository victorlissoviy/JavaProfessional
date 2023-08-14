package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {
  List<Socket> socketList = new ArrayList<>();

  private void serverWork(Socket socket) {
    try (InputStreamReader isr = new InputStreamReader(socket.getInputStream());
         BufferedReader br = new BufferedReader(isr)) {

      String line;
      while (!(line = br.readLine()).isEmpty()) {
        for (Socket socketFor : socketList) {
          if (socketFor != socket) {
            OutputStreamWriter osw = new OutputStreamWriter(socketFor.getOutputStream());

            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(line + "\n");
            bw.flush();

          }
        }
      }

      socketList.remove(socket);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.start();
  }

  private void start() {
    try (ServerSocket serverSocket = new ServerSocket(2222)) {

      Socket socket;
      while ((socket = serverSocket.accept()) != null) {
        socketList.add(socket);
        Socket finalSocket = socket;
        Thread thread = new Thread(() -> serverWork(finalSocket));
        thread.start();
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
