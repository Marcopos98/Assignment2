////////////////////////////////////////////////////////////////////
// Marco Positello 1167693
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.Bill;

import java.util.List;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BillTest {
	List<MenuItem> listItems;
	Bill bill;
	
	@Before
    public void start() {
        bill = new Bill();
        listItems = new ArrayList<MenuItem>();
    }

    @Test
    public void emptyList() throws TakeAwayBillException{
        double total = bill.getOrder(listItems);
        assert(total == 0.0);
    }

    @Test(expected=TakeAwayBillException.class)
    public void moreThan30Elements() throws TakeAwayBillException{
        for(int i=0; i<=30; i++) {
            listItems.add(new MenuItem(ItemType.Sandwich, "test", 0.0));
        }
        @SuppressWarnings("unused")
        double total = bill.getOrder(listItems);
    }

    @Test
    public void moreThan5Sandwiches() throws TakeAwayBillException{
        for(int i=0; i<4; i++) {
            listItems.add(new MenuItem(ItemType.Sandwich, "test", 10.0));
        }
        listItems.add(new MenuItem(ItemType.Sandwich, "test", 2.0));
        double total = bill.getOrder(listItems);
        assert(total == 41);
    }
    
    @Test
    public void totalOfSandwichesAndFriesGtThan50 () throws TakeAwayBillException{
        for(int i=0; i<4; i++) {
            listItems.add(new MenuItem(ItemType.Sandwich, "test", 10.0));
        }
        listItems.add(new MenuItem(ItemType.Fries, "test", 10.0));
        double total = bill.getOrder(listItems);
        assert(total == 45);
    }
    
    @Test
    public void totalLessThan10 () throws TakeAwayBillException{
        for(int i=0; i<4; i++) {
            listItems.add(new MenuItem(ItemType.Sandwich, "test", 1.0));
        }
        double total = bill.getOrder(listItems);
        assert(total == 4.5);
    }
    
    @Test
    public void mixedList () throws TakeAwayBillException{
        for(int i=0; i<5; i++) {
            listItems.add(new MenuItem(ItemType.Sandwich, "test", 20.0));
        }
        for(int i=0; i<5; i++) {
            listItems.add(new MenuItem(ItemType.Fries, "test", 10.0));
        }
        for(int i=0; i<5; i++) {
            listItems.add(new MenuItem(ItemType.Beverage, "test", 1.0));
        }
        
        double total = bill.getOrder(listItems);
        assert(total == 130.5);
    }
}
