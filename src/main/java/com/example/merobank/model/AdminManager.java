package com.example.merobank.model;

public class AdminManager {
    private IAdminDAO adminDAO;

    public AdminManager(IAdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public Admin getAdmin(String username, String password) {
        return adminDAO.getAdmin(username, password);
    }
}
