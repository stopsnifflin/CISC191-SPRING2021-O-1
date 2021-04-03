package edu.sdccd.cisc191.o;

import java.net.*;
import java.io.*;

public class User {
    private String userName;

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }



    public void editLog(){

    }
    public DailyLog sendRequest() throws Exception {
        out.println(Request.toJSON(new Request(1)));
        return DailyLog.fromJSON(in.readLine());
    }

    public void logout() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        //Exit frame back to signin frame
    }


    public static void main(String[] args) {
        User client = new User();
        try {
            client.startConnection("127.0.0.1", 8888);
            System.out.println(client.sendRequest().toString());
            client.logout();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
