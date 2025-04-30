package org.transacciones_bancarias.application.dto;

import java.math.BigDecimal;

/**
 * abstracción del reporte
 */
public class TransactionReport {
    private final BigDecimal finalBalance;
    private final String highestTransactionId;
    private final BigDecimal highestTransactionAmount;
    private final int creditTransactionCount;
    private final int debitTransactionCount;
    /**
     * Constructor de una instancia del Reporte de transacciones
     * @param finalBalance monto total de transacciones
     * @param highestTransactionId id de la mayor transacción
     * @param highestTransactionAmount monto de mayor transacción
     * @param creditTransactionCount conteo de transacciones de tipo crédito
     * @param debitTransactionCount conteo de transacciones de tipo débito
     */
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

    /**
     * Retorna el valor de balance final
     * @return monto balance final
     */
    public BigDecimal getFinalBalance(){
        return finalBalance;
    }

    /**
     * Retorna id de la transacción de mayor monto
     * @return id transacción
     */
    public String getHighestTransactionId(){
        return highestTransactionId;
    }

    /**
     * Retorna valor de transacción que ha tenido el mayor moonto
     * @return transacción con mayor monto
     */
    public BigDecimal getHighestTransactionAmount(){
        return highestTransactionAmount;
    }

    /**
     * Retorna cantidad de transacciones de tipo crédito
     * @return transacción tipo crédito
     */
    public int getCreditTransactionCount(){
        return creditTransactionCount;
    }

    /**
     * Retorna cantidad de transacciones de tipo débito
     * @return transacciones tipo débito
     */
    public int getDebitTransactionCount(){
        return debitTransactionCount;
    }
}
