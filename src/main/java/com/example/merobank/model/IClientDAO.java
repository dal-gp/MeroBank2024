package com.example.merobank.model;

import java.util.List;

public interface IClientDAO {
    public Client getClient(String payeeAddress, String password);
}
