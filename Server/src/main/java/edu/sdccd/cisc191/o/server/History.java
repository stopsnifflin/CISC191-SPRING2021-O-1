package edu.sdccd.cisc191.o.server;

import edu.sdccd.cisc191.o.CustomerRequest;
import edu.sdccd.cisc191.o.CustomerResponse;
import edu.sdccd.cisc191.o.DailyLog;
import edu.sdccd.cisc191.o.Request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class History {
    private ArrayList<DailyLog> logHistory;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws Exception {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            Request request = Request.fromJSON(inputLine);
            out.println(DailyLog.toJSON(getLog(request.getLogEntryDay())));
        }
    }


    public DailyLog getLog(int entryAtDay){
        logHistory.add(new DailyLog()); //For now add an empty dailylog to logHistory
        return logHistory.get(entryAtDay-1);
    }
    public void addEntry(){

    }

    public void viewLogs(){

    }
}
