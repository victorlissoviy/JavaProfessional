package client;

import java.io.*;
import java.net.Socket;

public class Main {

  private static void readAndShow(Socket socket) {
    try (InputStreamReader bis = new InputStreamReader(socket.getInputStream());
         BufferedReader br = new BufferedReader(bis)) {

      String line;
      while ((line = br.readLine()) != null && !line.isEmpty()) {
        System.out.println(line);
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 2222);
         OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
         BufferedWriter bw = new BufferedWriter(osw);

         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(isr)) {

      new Thread(() -> readAndShow(socket)).start();

      String line;
      while ((line = br.readLine()) != null && !line.isEmpty()) {
        bw.write(line + "\n");
        bw.flush();
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
