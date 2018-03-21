package com.test.entity;

import javax.persistence.*;

@Entity(name = "product")
@Table(name = "easybuy_product")
public class Product {

    @Id
    @GeneratedValue
    private Integer ID;
    @Column(name = "EP_NAME")
    private String name;
    @Column(name = "EP_DESCRIPTION")
    private String description;
    @Column(name = "EP_PRICE")
    private String price;
    @Column(name = "EP_STOCK")
    private Integer stock;
    @Column(name = "EPC_ID")
    private Integer epc_ID;
    @Column(name = "EPC_CHILD_ID")
    private Integer epc_child_ID;
    @Column(name = "EP_FILE_NAME")
    private String file_name;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getEpc_ID() {
        return epc_ID;
    }

    public void setEpc_ID(Integer epc_ID) {
        this.epc_ID = epc_ID;
    }

    public Integer getEpc_child_ID() {
        return epc_child_ID;
    }

    public void setEpc_child_ID(Integer epc_child_ID) {
        this.epc_child_ID = epc_child_ID;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
