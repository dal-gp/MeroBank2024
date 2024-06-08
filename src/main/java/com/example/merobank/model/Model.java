package com.example.merobank.model;

import com.example.merobank.view.ViewFactory;

public class Model {
    private static Model instance;
    private ClientManager clientManager;
    private Client client;
    private boolean clientLoginSuccessFlag;

    private final ViewFactory viewFactory;

    private Model(){
        this.viewFactory = new ViewFactory();
        this.clientManager = new ClientManager(new SqliteClientDAO());
        this.client = new Client("", "", "", null, null, null);
    };

    public boolean isClientLoginSuccessFlag() {
        return clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean clientLoginSuccessFlag) {
        this.clientLoginSuccessFlag = clientLoginSuccessFlag;
    }

    public Client getClient() {
        return client;
    }

    public static Model getInstance(){
        if(instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public void evaluateClientCredential(String payeeAddress, String password) {
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        client = clientManager.getClientDetails(payeeAddress, password);
        if(client != null) {
            clientLoginSuccessFlag = true;
            System.out.println(client);
        }
    }
}