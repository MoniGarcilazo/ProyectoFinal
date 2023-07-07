/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author monig
 */
public class CamposObligatoriosException extends RuntimeException{

    public CamposObligatoriosException() {
    }

    public CamposObligatoriosException(String message) {
        super(message);
    }

    public CamposObligatoriosException(Throwable cause) {
        super(cause);
    }
    
}
