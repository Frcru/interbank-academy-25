package org.transacciones_bancarias.application.service;


import org.transacciones_bancarias.application.dto.TransactionReport;
import org.transacciones_bancarias.domain.exception.ProcessingException;
import org.transacciones_bancarias.domain.model.Transaction;
import org.transacciones_bancarias.domain.model.TransactionType;
import org.transacciones_bancarias.infrastructure.repository.CsvTransactionRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Procesa archivo csv, haciendo uso de clase CsvTransactionRepository para generar un reporte.
 * Tiene por finalidad hacer el conteo de tipo de transacción (Crédito o Débito)
 * Identificar la transacción con mayor monto.
 * @author Frank
 * @version 1.0
 */


public class TransactionService {
    /**
     * Constructor de la clase TransactionService
     * @param repository lee línea de archivo csv y lo almacena en Lista<Transaction>/Transaction>
     */
    private final CsvTransactionRepository repository;

    public TransactionService(CsvTransactionRepository repository){
        this.repository = repository;
    }

    /**
     *
     * @param transactions, es la lista de transaccione bancarias a ser procesadas
     * @return Objeto de tipo TransactionReport(clase) {@link TransactionReport}
     */
    public TransactionReport generateReport(List<Transaction> transactions){
        BigDecimal finalBalance = BigDecimal.ZERO;
        BigDecimal highestAmount = BigDecimal.ZERO;
        String highestTransactionId = "";
        int creditCount = 0;
        int debitCount = 0;

        for(Transaction transaction:transactions){
            if(transaction.getType() == TransactionType.CREDIT){
                finalBalance = finalBalance.add(transaction.getAmount());
                creditCount++;
            }else{
                finalBalance = finalBalance.subtract(transaction.getAmount());
                debitCount++;
            }

            if(transaction.getAmount().compareTo(highestAmount)>0){
                highestAmount = transaction.getAmount();
                highestTransactionId = transaction.getID();
            }
        }

        finalBalance = finalBalance.setScale(2, RoundingMode.HALF_UP);

        return new TransactionReport(
                finalBalance,
                highestTransactionId,
                highestAmount,
                creditCount,
                debitCount
        );
    }
}
