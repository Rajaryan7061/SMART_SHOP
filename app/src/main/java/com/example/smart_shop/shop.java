package com.example.smart_shop;


public class shop {
    private String shopName,address,phoneNumber;
    public shop(){

    }
    public shop(String shopName,String address,String phoneNumber ){
        this.shopName=shopName;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }
    public String getShopName(){
        return shopName;
    }
    public void setShopName(String shopName){
        this.shopName=shopName;

    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getPhoneNumber(){
        return phoneNumber;

    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

}
