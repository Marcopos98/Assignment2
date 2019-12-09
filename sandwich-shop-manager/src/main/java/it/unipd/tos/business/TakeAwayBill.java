////////////////////////////////////////////////////////////////////
// Marco Positello 1167693
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public interface TakeAwayBill {
    double getOrder(List<MenuItem> itemOrdered) throws TakeAwayBillException;
}
