package edu.sdccd.cisc191.o.client;

import edu.sdccd.cisc191.o.DailyLog;
import edu.sdccd.cisc191.o.Request;

import java.net.*;
import java.io.*;

public class User {
    private String userName;
    private String password;

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    //Default constructor
    public User() {
        userName = "userName";
        password = "password";
    }

    //Constructor
    public User(String param_userName, String param_password) {
        userName = param_userName;
        password = param_password;
    }

    //Setter
    public void setUserName(String param_userName) {
        userName = param_userName;
    }

    //Setter
    public void setPassword(String param_password) {
        password = param_password;
    }

    //Getter
    public String getUserName() {
        return userName;
    }

    //Getter
    public String getPassword() {
        return password;
    }

    /**
     * startConnection() creates a connection with Server
     * @param ip server ip
     * @param port use 8888
     * @throws IOException
     */
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);    //Client Socket created to given port & ip
        out = new PrintWriter(clientSocket.getOutputStream(), true);    //output from client to the other end of socket(server)
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  //input from the other end of the socket(server)
    }

    /**
     * sendRequest() sends a request to Server and returns a DailyLog
     * @return DailyLog
     * @throws Exception
     */
    public DailyLog sendRequest() throws Exception {
        out.println(Request.toJSON(new Request(1)));    //outputting to server a JSON serialized  object of Request
        return DailyLog.fromJSON(in.readLine());    //outputting to server a JSON serialized  object of Request
    }

    /**
     * logout() closes all connections
     * @throws IOException
     */
    public void logout() throws IOException {
        //Close all the I/O streams and disconnect clientSocket
        in.close();
        out.close();
        clientSocket.close();
    }

/*  main() COMMENTED OUT
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
*/

    public void editLog(){
        //FIX ME
    }

}
