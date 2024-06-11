package com.example.merobank.model;

import com.example.merobank.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Model {
    private static Model instance;
    private ClientManager clientManager;
    private AdminManager adminManager;
    private SqliteAccountDAO accountDAO;
    private Client client;
    private boolean clientLoginSuccessFlag;
    private boolean adminLoginSuccessFlag;
    private ObservableList<Client> clients; // 2

    private final ViewFactory viewFactory;

    private Model(){
        this.viewFactory = new ViewFactory();
        this.clientManager = new ClientManager(new SqliteClientDAO());
        this.adminManager = new AdminManager(new SqliteAdminDAO());
        this.accountDAO = new SqliteAccountDAO();
        this.client = new Client("", "", "", null, null, null);
        clientLoginSuccessFlag = false;
        adminLoginSuccessFlag = false;
        clients = FXCollections.observableArrayList(); // 3
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


    public ObservableList<Client> getClients() {
        return clients;
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

    public void createCheckingAccount(CheckingAccount checkingAccount){
        accountDAO.addCheckingAccount(checkingAccount);
    }

    public void createSavingsAccount(SavingsAccount savingsAccount) {
        accountDAO.addSavingsAccount(savingsAccount);
    }

    public void createClient(String firstName, String lastName, String payeeAddress, String password, LocalDate now) {
        clientManager.addClient(firstName,lastName,payeeAddress,password,now);
    }

    public int getLastClientsId(){
        return clientManager.getLastClientsId();
    }

    public void setClients(){

        // 1. get all client
        // loop -> set sa,ca and add it to the clients list
        for(Client client : clientManager.getAllClients()){
            CheckingAccount checkingAccount = accountDAO.getCheckingAccount(client.getPayeeAddress());
            SavingsAccount savingsAccount =accountDAO.getSavingsAccount(client.getPayeeAddress());
            client.checkingAccountProperty().set(checkingAccount);
            client.savingsAccountProperty().set(savingsAccount);
            clients.add(client);
        }
    }
}