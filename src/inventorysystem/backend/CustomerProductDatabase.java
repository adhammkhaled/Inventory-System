package inventorysystem.backend;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class CustomerProductDatabase extends Database<CustomerProduct>{

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public CustomerProductDatabase(String filename) {
        super(filename);
    }

    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        CustomerProduct customerProduct = new CustomerProduct(parts[0], parts[1], LocalDate.parse(parts[2],formatter));
        return customerProduct;
    }

    public boolean contains(String key) {
        boolean found = false;
        for (int i = 0; i < this.records.size(); i++) {
            if (key.equals(records.get(i).getCustomerSSN())) {
                found = true;
                break;
            }
        }
        return found;
    }

    public CustomerProduct getRecord(String key) {
        System.out.println(this.records.size());
        for (int i = 0; i < this.records.size(); i++) {
            
            if (key.equals(records.get(i).getCustomerSSN())) {
                
                return (CustomerProduct) records.get(i);
            }
        }
        return null;
    }

    

    public void deleteRecord(String key) {
        for (int i = 0; i < this.records.size(); i++) {
            if (key.equals(records.get(i).lineRepresentation())) {
                this.records.remove(records.get(i));
            }
        }
    }
    
}
