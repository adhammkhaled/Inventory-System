
package inventorysystem.backend;

import static inventorysystem.constants.FileNames.EMPLOYEE_FILENAME;


public class AdminRole {
    private EmployeeUserDatabase database = new EmployeeUserDatabase(EMPLOYEE_FILENAME);
    public AdminRole(){
        database.readFromFile();
    }
    public void addEmployee(String employeeId, String name, String email, String 
    address, String phoneNumber){
        
        EmployeeUser employee = new EmployeeUser(employeeId,name,email,address,phoneNumber);
        this.database.insertRecord(employee);
    }
    
    public EmployeeUser[] getListOfEmployees(){
        EmployeeUser[] employeeArray = new EmployeeUser[this.database.returnAllRecords().size()];
        employeeArray = (EmployeeUser[]) this.database.returnAllRecords().toArray(employeeArray);
        return employeeArray;
        
    }
     public void removeEmployee(String key){
         this.database.deleteRecord(key);
     }
     public void logout(){
         this.database.saveToFile();
     }
}

