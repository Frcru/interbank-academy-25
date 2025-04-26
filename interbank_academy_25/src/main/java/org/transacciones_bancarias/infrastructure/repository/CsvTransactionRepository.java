package org.transacciones_bancarias.infrastructure.repository;

import org.transacciones_bancarias.domain.exception.ProcessingException;
import org.transacciones_bancarias.domain.model.Transaction;
import org.transacciones_bancarias.infrastructure.util.CsvParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvTransactionRepository {
    private final CsvParser csvParser= new CsvParser();

    public List<Transaction> loadTransactions(String filePath) throws ProcessingException{
        List<Transaction> transactions = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
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
