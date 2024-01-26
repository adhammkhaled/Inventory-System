
package inventorysystem.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class ProductDatabase extends Database<Product> {
    public ProductDatabase(String filename){
        super(filename);
   
    }

    public Product createRecordFrom(String line){
        String[] parts= line.split(",");
        Product product = new Product(parts[0],parts[1],parts[2],parts[3],Integer.parseInt(parts[4]),
                Float.parseFloat(parts[5])); 
        return product;
    }

    public boolean contains(String key){
        boolean found=false;
        for(int i=0;i<this.records.size();i++){
            if(key==records.get(i).getProductID()){
                found=true;
                break;
            }
        }
        return found;
    }
    public Product getRecord(String key) {
       
        for(int i=0;i<this.records.size();i++){
            if(key==records.get(i).getProductID()){
                return (Product) records.get(i);
            }
        }
        return null;
     }
     public void deleteRecord(String key){
         for(int i=0;i<this.records.size();i++){
            if(key.equals(records.get(i).getProductID())){
                this.records.remove(records.get(i));
            }
        }
     }
}
