////////////////////////////////////////////////////////////////////
// Marco Positello 1167693
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class Bill implements TakeAwayBill {

    @Override
    public double getOrder(List<MenuItem> itemOrdered) throws TakeAwayBillException {
        if (itemOrdered.size() == 0) {
            return 0.0;
        }
        if (itemOrdered.size() > 30) {
            throw new TakeAwayBillException("You can't have more than 30 elements!");
        }

        double sum = 0.0;
        int numOfSandwiches = 0;
        int indexOfCheapSandwich = -1;
        double sumOfSandwichesAndFries = 0;

        for (int i = 0; i < itemOrdered.size(); i++) {
            MenuItem mt = itemOrdered.get(i);

            sum += mt.getPrice();

            if (mt.getItemType() == ItemType.Sandwich) {
                numOfSandwiches++;
                if (numOfSandwiches == 1 || mt.getPrice() < itemOrdered.get(indexOfCheapSandwich).getPrice()) {
                    indexOfCheapSandwich = i;
                }
            }

            if (mt.getItemType() == ItemType.Sandwich || mt.getItemType() == ItemType.Fries) {
                sumOfSandwichesAndFries += mt.getPrice();
            }
        }

        if (numOfSandwiches >= 5) {
            sum -= itemOrdered.get(indexOfCheapSandwich).getPrice() * 0.5;
        }

        if (sumOfSandwichesAndFries >= 50) {
            sum -= sum * 0.1;
        }

        if (sum < 10.0) {
            sum += 0.5;
        }

        return sum;
    }

}
