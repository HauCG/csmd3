package org.example.managementapplication.model;

public class UserAccount {
    private int idAccount;
    private String nameAccount;
    private int agesAccount;
    private String emailAccount;
    private String addressAccount;
    private String usernameAccount;
    private String passwordAccount;
    private String roleAsAccount;
    private Double baclanceAccount;
    public UserAccount() {};
    public UserAccount(int idAccount, String nameAccount, int agesAccount, String emailAccount, String addressAccount, String usernameAccount, String passwordAccount, String roleAsAccount, Double baclanceAccount) {
        this.idAccount = idAccount;
        this.nameAccount = nameAccount;
        this.agesAccount = agesAccount;
        this.emailAccount = emailAccount;
        this.addressAccount = addressAccount;
        this.usernameAccount = usernameAccount;
        this.passwordAccount = passwordAccount;
        this.roleAsAccount = roleAsAccount;
        this.baclanceAccount = baclanceAccount;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public int getAgesAccount() {
        return agesAccount;
    }

    public void setAgesAccount(int agesAccount) {
        this.agesAccount = agesAccount;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    public String getAddressAccount() {
        return addressAccount;
    }

    public void setAddressAccount(String addressAccount) {
        this.addressAccount = addressAccount;
    }

    public String getUsernameAccount() {
        return usernameAccount;
    }

    public void setUsernameAccount(String usernameAccount) {
        this.usernameAccount = usernameAccount;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }

    public String getRoleAsAccount() {
        return roleAsAccount;
    }

    public void setRoleAsAccount(String roleAsAccount) {
        this.roleAsAccount = roleAsAccount;
    }

    public Double getBaclanceAccount() {
        return baclanceAccount;
    }

    public void setBaclanceAccount(Double baclanceAccount) {
        this.baclanceAccount = baclanceAccount;
    }
}


