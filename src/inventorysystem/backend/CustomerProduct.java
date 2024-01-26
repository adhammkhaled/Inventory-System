package inventorysystem.backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct implements RecordInterface{

    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate)  {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }

    public String getCustomerSSN() {
        return this.customerSSN;
    }

    public String getProductID() {
        return this.productID;
    }

    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    public String lineRepresentation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedLocalDate = purchaseDate.format(formatter);
        return this.customerSSN + "," + this.productID + "," + formattedLocalDate;
    }

    public String getSearchKey() {
        return lineRepresentation();
    }
}
