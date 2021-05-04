package sample;

import java.util.List;

public interface InvoiceDao {
    void addInvoice(Invoice invoice);
    void updateInvoice(Invoice invoice);
    void deleteInvoice(Invoice invoice);
    List<Invoice> getAllInvoice();
}
