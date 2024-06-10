package com.example.merobank.model;

import java.time.LocalDate;

public class ClientManager {
    private IClientDAO clientDAO;

    public ClientManager(IClientDAO clientDAO){
        this.clientDAO = clientDAO;
    }

    public Client getClientDetails(String payeeAddress, String password){
        Client client = clientDAO.getClient(payeeAddress, password);
        return client;
    }

    public void addClient(String firstName, String lastName, String payeeAddress,
                          String password, LocalDate date){
        this.clientDAO.addClient(firstName, lastName, payeeAddress, password, date);
    }

    public int getLastClientsId() {
        return clientDAO.getClientsLastId();
    }
}
