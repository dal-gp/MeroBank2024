package com.example.merobank.model;

import com.example.merobank.view.ViewFactory;

public class Model {
    private static Model instance;
    private ClientManager clientManager;
    private AdminManager adminManager;
    private Client client;
    private boolean clientLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;

    private final ViewFactory viewFactory;

    private Model(){
        this.viewFactory = new ViewFactory();
        this.clientManager = new ClientManager(new SqliteClientDAO());
        this.adminManager = new AdminManager(new SqliteAdminDAO());
        this.client = new Client("", "", "", null, null, null);
        clientLoginSuccessFlag = false;
        adminLoginSuccessFlag = false;
    };

    public boolean isClientLoginSuccessFlag() {
        return clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean clientLoginSuccessFlag) {
        this.clientLoginSuccessFlag = clientLoginSuccessFlag;
    }

    public boolean isAdminLoginSuccessFlag() {
        return adminLoginSuccessFlag;
    }

    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag) {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
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
        }
    }

    public void evaluateAdminCredential(String username, String password) {
        //declaring admin here , as we are not using this anywhere
        Admin admin = new Admin("", "");
        admin = adminManager.getAdmin(username, password);
        if(admin != null) {
            adminLoginSuccessFlag = true;
        }
    }
}