package com.example.merobank.model;

import java.time.LocalDate;
import java.util.List;

public interface IClientDAO {
    public Client getClient(String payeeAddress, String password);
//    public void addClient(Client client);
    public void addClient( String firstName, String lastName, String payeeAddress,
                           String password, LocalDate date);

    public int getClientsLastId();
}
