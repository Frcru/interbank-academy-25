package org.transacciones_bancarias.domain.model;
import java.math.BigDecimal;

public class Transaction {
    private final String id;
    private final TransactionType type;
    private final BigDecimal amount;

    public Transaction(String id, TransactionType type, BigDecimal amount){
        this.id=id;
        this.type=type;
        this.amount=amount;
    }

    public String getID(){
        return id;
    }

    public TransactionType getType(){
        return type;
    }

    public BigDecimal getAmount(){
        return amount;
    }
}
