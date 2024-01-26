package inventorysystem.backend;

import static inventorysystem.constants.FileNames.CUSTOMERPRODUCT_FILENAME;
import static inventorysystem.constants.FileNames.PRODUCT_FILENAME;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class EmployeeRole {

    private ProductDatabase productDatabase = new ProductDatabase(PRODUCT_FILENAME);
    private CustomerProductDatabase customerProductDatabase = new CustomerProductDatabase(CUSTOMERPRODUCT_FILENAME);

    public EmployeeRole() {
        productDatabase.readFromFile();
        customerProductDatabase.readFromFile();
    }

    public void addProduct(String productId, String productname, String manufacturerName, String supplierName, int quantity, float price) {
        Product product = new Product(productId, productname, manufacturerName, supplierName, quantity, price);
        this.productDatabase.insertRecord(product);
    }

    public Product[] getListOfProducts() {
        Product[] productArray = new Product[this.productDatabase.returnAllRecords().size()];
        productArray = (Product[]) this.productDatabase.returnAllRecords().toArray(productArray);
        return productArray;

    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        CustomerProduct[] customerProductArray = new CustomerProduct[this.customerProductDatabase.returnAllRecords().size()];
        customerProductArray = (CustomerProduct[]) this.customerProductDatabase.returnAllRecords().toArray(customerProductArray);
        return customerProductArray;

    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {

        for (Product product : getListOfProducts()) {
            
            if (product.getProductID().equals(productID) && product.getQuantity() == 0) {

                return false;

            }
            if (product.getProductID().equals(productID) && product.getQuantity() > 0) {

                product.setQuantity(product.getQuantity() - 1);
                CustomerProduct customerproduct = new CustomerProduct(customerSSN, productID, purchaseDate);
                customerProductDatabase.insertRecord(customerproduct);
                
                return true;

            }
        }

        return false;

    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {

        boolean found1 = false;
        boolean found2 = false;
        boolean found3 = false;
        Product foundProduct = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedLocalDate = purchaseDate.format(formatter);
        String customerProductRecordRepresentation=customerSSN+","+productID+","+formattedLocalDate;
        for (Product product : getListOfProducts()) {
            if (product.getProductID().equals(productID)) {
                found1 = true;
                foundProduct = product;
                Period period = Period.between(purchaseDate, returnDate);
                if (period.getDays() <= 14 && period.getDays() >= 0 && period.getMonths() == 0 && period.getYears() == 0) {
                    found2 = true;

                }
            }
        }
        for (CustomerProduct customerProduct : getListOfPurchasingOperations()) {
            if (customerProduct.getProductID().equals(productID) && customerProduct.getCustomerSSN().equals(customerSSN)) {
                found3 = true;
            }
        }
        if (found1 && found2 && found3) {
            customerProductDatabase.deleteRecord(customerProductRecordRepresentation);
            foundProduct.setQuantity(foundProduct.getQuantity() + 1);

            
            return foundProduct.getPrice();

        }

        return -1;
    }

    public void logout() {

        this.productDatabase.saveToFile();
        this.customerProductDatabase.saveToFile();

    }
}
