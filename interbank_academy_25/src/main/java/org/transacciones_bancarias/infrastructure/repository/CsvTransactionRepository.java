package org.transacciones_bancarias.infrastructure.repository;

import org.transacciones_bancarias.domain.exception.ProcessingException;
import org.transacciones_bancarias.domain.model.Transaction;
import org.transacciones_bancarias.infrastructure.util.CsvParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de cargar las transacciones bancarias que esten en el archivo csv especificado.
 * usa {@link CsvParser} para realizar parsing de cada linea individual.
 */
public class CsvTransactionRepository {
    //Instancia de parser para convertir cada linea del csv en objeto Transaction.
    private final CsvParser csvParser= new CsvParser();

    /**
     * Carga todas las transacciones del archivo csv.
     * En el método se asume que la primera línea tiene encabezado, por lo que se lee a primera línea del csv.
     * Cada salto de linea (lectura) se hace parse en objeto {@link Transaction}.
     * @param filePath ruta del archivo CSV, que contiene los datos.
     * @return una lista de objetos {@link Transaction} que satisfactoriamente se parsearon.
     * @throws ProcessingException si se detecta un error mientras se lee el archivo o si alguna linea falla en hacer parse en {@link CsvParser}.
     */
    public List<Transaction> loadTransactions(String filePath) throws ProcessingException{
        List<Transaction> transactions = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Line para omitir el primer grupo de datos
            reader.readLine();
            //Lee cada una de las lineas del archivo csv
            while((line=reader.readLine())!=null){
                Transaction transaction = csvParser.parseTransactionLine(line);
                transactions.add(transaction);
            }
            return transactions;
        } catch(IOException e){
            throw new ProcessingException("Error al leer el csv" + e.getMessage()+e);
        }
    }
}
