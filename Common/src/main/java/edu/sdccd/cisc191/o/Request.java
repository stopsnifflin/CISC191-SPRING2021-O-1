package edu.sdccd.cisc191.o;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Request {
    private int logEntryDay;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(Request logEntryDay) throws Exception {
        return objectMapper.writeValueAsString(logEntryDay);
    }
    public static Request fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, Request.class);
    }
    public Request(int logEntryDay) {
        this.logEntryDay = logEntryDay;
    }

    public int getLogEntryDay(){
        return logEntryDay;
    }

    @Override
    public String toString() {
        return String.format("Day[%d] ", logEntryDay);
    }



}
