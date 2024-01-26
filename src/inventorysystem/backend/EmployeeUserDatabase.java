package inventorysystem.backend;


class EmployeeUserDatabase extends Database<EmployeeUser> {

    public EmployeeUserDatabase(String filename){
        super(filename);
   
    }
    public EmployeeUser createRecordFrom(String line){
        String[] parts= line.split(",");
        EmployeeUser employee = new EmployeeUser(parts[0],parts[1],parts[2],parts[3],parts[4]); 
        return employee;
    }
    public boolean contains(String key){
        boolean found=false;
        for(int i=0;i<this.records.size();i++){
            if(key.equals(records.get(i).getEmployeeId())){
                found=true;
                break;
            }
        }
        return found;
    }
     public EmployeeUser getRecord(String key) {
       
        for(int i=0;i<this.records.size();i++){
            if(key.equals(records.get(i).getEmployeeId())){
                return records.get(i);
            }
        }
        return null;
     }
     
     public void deleteRecord(String key){
         for(int i=0;i<this.records.size();i++){
            if(key.equals(records.get(i).getEmployeeId())){
                this.records.remove(records.get(i));
            }
        }
     }
         
         
}
      
      
     
    
