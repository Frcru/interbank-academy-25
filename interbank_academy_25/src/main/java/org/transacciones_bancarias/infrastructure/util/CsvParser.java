package org.transacciones_bancarias.infrastructure.util;

import org.transacciones_bancarias.domain.exception.ProcessingException;
import org.transacciones_bancarias.domain.model.Transaction;
import org.transacciones_bancarias.domain.model.TransactionType;

import java.math.BigDecimal;

public class CsvParser {
    public Transaction parseTransactionLine(String line) throws ProcessingException {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new ProcessingException("Formato de línea inválido" + line);
        }

        String id = parts[0];
        String typeStr = parts[1];
        //Transformando String a TransactionType (método fromString)
        try {

            TransactionType type = TransactionType.fromString(typeStr);
            BigDecimal amount = new BigDecimal(parts[2]);
            return new Transaction(id, type, amount);


        } catch (NumberFormatException e) {
            throw new ProcessingException("Monto inválido en la línea:" + line,e);
        } catch (IllegalArgumentException e){
            throw new ProcessingException("Tipo de transacción inválido:"+typeStr,e);
        }
    }


}
