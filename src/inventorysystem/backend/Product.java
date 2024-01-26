/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem.backend;

/**
 *
 * @author adham
 */
public class Product implements RecordInterface {
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;
    public Product(String productID, String productName, String manufacturerName, String 
supplierName, int quantity, float price){
    this.productID = productID;
    this.productName = productName;
    this.manufacturerName = manufacturerName;
    this.supplierName = supplierName;
    if(quantity>0)
        this.quantity = quantity;
    else
        this.quantity=0;
    
    if(price>0)
        this.price = price;
    else
        this.price = 0;
    }
    public int getQuantity(){
        return this.quantity;
    }
    
    public float getPrice(){
        return this.price;
    }
    public void setQuantity(int quantity){
    if(quantity>=0)
        this.quantity = quantity;
    else{
        this.quantity=0;
        System.out.println("Invalid negative quantity, setted quantity to 0");
    }
    }
    public String getProductID(){
        return this.productID;
    }
    
     public String lineRepresentation(){
         return this.productID+","+this.productName+","+this.manufacturerName+","+
                 this.supplierName+","+this.quantity+","+this.price;
     }
      public String getSearchKey(){
          return this.productID;
      }
     



}
