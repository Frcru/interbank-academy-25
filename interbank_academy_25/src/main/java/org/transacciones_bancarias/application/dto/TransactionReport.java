package org.transacciones_bancarias.application.dto;

import java.math.BigDecimal;

public class TransactionReport {
    private final BigDecimal finalBalance;
    private final String highestTransactionId;
    private final BigDecimal highestTransactionAmount;
    private final int creditTransactionCount;
    private final int debitTransactionCount;

    public TransactionReport(
            BigDecimal finalBalance,
            String highestTransactionId,
            BigDecimal highestTransactionAmount,
            int creditTransactionCount,
            int debitTransactionCount){
        this.finalBalance = finalBalance;
        this.highestTransactionId = highestTransactionId;
        this.highestTransactionAmount = highestTransactionAmount;
        this.creditTransactionCount = creditTransactionCount;
        this.debitTransactionCount = debitTransactionCount;
    }
    public BigDecimal getFinalBalance(){
        return finalBalance;
    }
    public String getHighestTransactionId(){
        return highestTransactionId;
    }
    public BigDecimal getHighestTransactionAmount(){
        return highestTransactionAmount;
    }
    public int getCreditTransactionCount(){
        return creditTransactionCount;
    }
    public int getDebitTransactionCount(){
        return debitTransactionCount;
    }
}
