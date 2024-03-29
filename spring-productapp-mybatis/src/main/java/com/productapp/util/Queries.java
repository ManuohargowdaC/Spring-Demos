package com.productapp.util;

public class Queries {
//	public static final String INSERTQUERY =
//            "INSERT INTO PRODUCT(product_Id,product_name,category,brand,price) VALUES(?,?,?,?,?)";
    public static final String UPDATEQUERY =  "UPDATE PRODUCT SET price=? where product_Id";
    public static final String DELETEQUERY =  "DELETE FROM PRODUCT WHERE product_Id=?";
    public static final String FINDALLQUERY = "SELECT * FROM PRODUCT";
    public static final String FINDBYCATEGORY = "SELECT * from PRODUCT where category=?";
    public static final String FINDBYCATEGORYANDBRAND = "SELECT * FROM PRODUCT CATEGORY=? and BARND=?";
    
    public static final String FINDBYCATEGORYANDPRICE = "SELECT * FROM PRODUCT price=? and PRICE<=?";
    public static final String FINDBYBRAND = "SELECT * FROM PRODUCT brand=?";
    public static final String FINDBYID = "SELECT * FROM PRODUCT WHERE product_id=?";

}
