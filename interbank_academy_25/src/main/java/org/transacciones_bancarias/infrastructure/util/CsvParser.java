package org.transacciones_bancarias.infrastructure.util;

import org.transacciones_bancarias.domain.exception.ProcessingException;
import org.transacciones_bancarias.domain.model.Transaction;
import org.transacciones_bancarias.domain.model.TransactionType;

import java.math.BigDecimal;

/**
 * Realiza el parse de CSV individual.
 * En objeto {@link Transaction}. Valida el formato de la linea de datos.
 * activa un{@link ProcessingException} si parse falla.
 */
public class CsvParser {
    /**
     * Realiza el Parse de cada dato separado por coma, en la que cada conjunto representa la transacción bancaria.
     * Se espera el formato "id,type,amount".
     * @param line es la linea string de csv que se espera realizar el parse.
     * @return un objeto {@link Transaction} parseado de la linea.
     * @throws ProcessingException Si el formato de la linea es invalido o falla en el parse de amount o tipo.
     */
    public Transaction parseTransactionLine(String line) throws ProcessingException {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new ProcessingException("Formato de línea inválido" + line);
        }

        String id = parts[0];
        String typeStr = parts[1];
        //Transformando String a TransactionType (método fromString).
        try {
            //verifica string y lo convierte en enum CREDIT o DEBIT.
            TransactionType type = TransactionType.fromString(typeStr);
            //parse string a BigDecimal.
            BigDecimal amount = new BigDecimal(parts[2]);
            return new Transaction(id, type, amount);


        } catch (NumberFormatException e) {
            throw new ProcessingException("Monto inválido en la línea:" + line,e);
        } catch (IllegalArgumentException e){
            throw new ProcessingException("Tipo de transacción inválido:"+typeStr,e);
        }
    }


}
