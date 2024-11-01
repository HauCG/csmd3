package org.example.managementapplication.model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String brandProduct;
    private double priceProduct;
    private String descriptionProduct;
    private int quantityProduct;
    private String statusProduct;

    public Product() {}
    public Product(Integer idProduct, String nameProduct, String brandProduct, double priceProduct, String descriptionProduct, int quantityProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.brandProduct = brandProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.quantityProduct = quantityProduct;
    }


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrandProduct() {
        return brandProduct;
    }

    public void setBrandProduct(String brandProduct) {
        this.brandProduct = brandProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }
}
