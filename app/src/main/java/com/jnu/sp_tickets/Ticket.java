package com.jnu.sp_tickets;

import android.os.Bundle;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String ticketType;
    private String ticketState;
    private String ticketIncome;
    private String ticketLocation;
    private String ticketDuration;

    public Ticket(String ticketType, String ticketState, String ticketIncome, String ticketLocation, String ticketDuration) {
        this.ticketType = ticketType;
        this.ticketState = ticketState;
        this.ticketIncome = ticketIncome;
        this.ticketLocation = ticketLocation;
        this.ticketDuration = ticketDuration;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketState() {
        return ticketState;
    }

    public void setTicketState(String ticketState) {
        this.ticketState = ticketState;
    }

    public String getTicketIncome() {
        return ticketIncome;
    }

    public void setTicketIncome(String ticketIncome) {
        this.ticketIncome = ticketIncome;
    }

    public String getTicketLocation() {
        return ticketLocation;
    }

    public void setTicketLocation(String ticketLocation) {
        this.ticketLocation = ticketLocation;
    }

    public String getTicketDuration() {
        return ticketDuration;
    }

    public void setTicketDuration(String ticketDuration) {
        this.ticketDuration = ticketDuration;
    }
}
