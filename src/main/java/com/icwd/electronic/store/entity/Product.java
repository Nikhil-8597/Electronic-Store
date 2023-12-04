package com.icwd.electronic.store.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_info")
public class Product {

    @Id
    private String productId;
    @Column(name="Product_Title")
    private String title;
    @Column(name="Product_Description")
    private String description;
    @Column(name="Product_Price")
    private Double price;
    @Column(name="Product_Quantity")
    private Long quantity;
    @Column(name="Product_Added_Date")
    private Date addeddate;
    @Column(name="Product_Live")
    private Boolean live;
    @Column(name="Product_Stock")
    private Boolean stock;
    @Column(name="Product_Descount_Price")
    private Double descountprice;
    @Column(name="Product_Image_Name")
    private String productimagename;



}