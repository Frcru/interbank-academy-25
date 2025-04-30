package org.transacciones_bancarias.domain.model;

import org.transacciones_bancarias.domain.exception.ProcessingException;
import java.math.BigDecimal;

/**
 * Abstracción de una transacción con identificador, tipo y monto
 */
public class Transaction {
    private final String id;
    private final TransactionType type;
    private final BigDecimal amount;

    /**
     * Constructor de instancia de {@code Transaction}
     * @param id identificador único de transacción.
     * @param type tipo enum de transacción {@link TransactionType}.
     * @param amount monto de transacción.
     * @throws ProcessingException si el monto es negativo, si id o tipo son null/empty.
     */
    public Transaction(String id, TransactionType type, BigDecimal amount) throws ProcessingException {
        //validaciones
        if(id==null || id.trim().isEmpty()){
            throw new ProcessingException("Transaction id no puede ser null o vacío");
        }
        if(type==null){
            throw new ProcessingException("Transaction type no puede ser null");
        }
        if(amount==null){
            throw new ProcessingException("Amount no puede ser null");
        }
        if(amount.compareTo(BigDecimal.ZERO)<0){
            throw new ProcessingException("Amount no puede ser negativo");
        }
        this.id=id;
        this.type=type;
        this.amount=amount;
    }

    /**
     * Devuelve el ID de la transacción.
     * @return id Transaction.
     */
    public String getID(){
        return id;
    }

    /**
     * Devuelve tipo de transacción.
     * @return tipo transacción.
     */
    public TransactionType getType(){
        return type;
    }

    /**
     * Devuelve el valor de transacción.
     * @return valor de transacción.
     */
    public BigDecimal getAmount(){
        return amount;
    }
}
