/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author adham
 * 
 */
abstract class Database<T extends RecordInterface> {
    protected ArrayList<T> records = new ArrayList<T>();
    protected String filename;
    public Database(String filename) {
        this.filename = filename;
    }
    public abstract T createRecordFrom(String line);
    public abstract boolean contains(String key);
    public abstract T getRecord(String key);
    public abstract void deleteRecord(String key);
    public void readFromFile(){
        try {
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
 
        while ((line = bufferedReader.readLine()) != null) {
            records.add((T) createRecordFrom(line));
            
        }
        bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<T> returnAllRecords(){
         return this.records;
    }
    
    public void insertRecord(T record) {
        this.records.add(record);
    }
    
    public void saveToFile(){
         File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))){
            
            for(int i=0;i<this.records.size();i++){
                writer.write(records.get(i).lineRepresentation());
                if(this.records.size()-i!=1)
                    writer.write("\n");
            
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }

    
    
    
    
}  
