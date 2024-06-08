package com.example.merobank.model;

public class ClientManager {
    private IClientDAO clientDAO;

    public ClientManager(IClientDAO clientDAO){
        this.clientDAO = clientDAO;
    }

    public Client getClientDetails(String payeeAddress, String password){
        Client client = clientDAO.getClient(payeeAddress, password);
        return client;
    }
}
