////////////////////////////////////////////////////////////////////
// Marco Positello 1167693
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

@SuppressWarnings("serial")
public class TakeAwayBillException extends Throwable{
    private String error;

    public TakeAwayBillException(String e) {
        error = e;
    }
}
