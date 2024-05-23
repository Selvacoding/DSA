import java.util.ArrayList;
import java.util.List;

class Invoice {
    private int invoiceNumber;
    private String customerName;
    private double amount;

    // Constructor
    public Invoice(int invoiceNumber, String customerName, double amount) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.amount = amount;
    }

    // Getters and setters
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                '}';
    }
}


class InvoiceManagement {
    private final List<Invoice> invoices;

    // Constructor
    public InvoiceManagement() {
        invoices = new ArrayList<>();
    }

    // Add invoice
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    // Get all invoices
    public List<Invoice> getInvoices() {
        return invoices;
    }

    // Get total amount of all invoices
    public double getTotalAmount() {
        double total = 0;
        for (Invoice invoice : invoices) {
            total += invoice.getAmount();
        }
        return total;
    }

    // Get invoice by invoice number
    public Invoice getInvoiceByNumber(int invoiceNumber) {
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceNumber() == invoiceNumber) {
                return invoice;
            }
        }
        return null; // If not found
    }
}

public class InvoiceManagementSystem {
    public static void main(String[] args) {
        // Create Invoice Management
        InvoiceManagement invoiceManagement = new InvoiceManagement();

        // Add some Invoices
        invoiceManagement.addInvoice(new Invoice(1, "Customer 1", 100.0));
        invoiceManagement.addInvoice(new Invoice(2, "Customer 2", 150.0));
        invoiceManagement.addInvoice(new Invoice(3, "Customer 3", 200.0));

        // Print all invoices
        System.out.println("All Invoices:");
        for (Invoice invoice : invoiceManagement.getInvoices()) {
            System.out.println(invoice);
        }

        // Get total amount
        System.out.println("Total Amount: " + invoiceManagement.getTotalAmount());

        // Get invoice by invoice number
        int searchInvoiceNumber = 2;
        Invoice foundInvoice = invoiceManagement.getInvoiceByNumber(searchInvoiceNumber);
        if (foundInvoice != null) {
            System.out.println("Found Invoice by number " + searchInvoiceNumber + ": " + foundInvoice);
        } else {
            System.out.println("Invoice with number " + searchInvoiceNumber + " not found.");
        }
    }
}


