package org.transacciones_bancarias;

import org.transacciones_bancarias.application.dto.TransactionReport;
import org.transacciones_bancarias.application.service.TransactionService;
import org.transacciones_bancarias.domain.exception.ProcessingException;
import org.transacciones_bancarias.domain.model.Transaction;
import org.transacciones_bancarias.infrastructure.repository.CsvTransactionRepository;
import org.transacciones_bancarias.presentation.console.ConsoleReportAppareance;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("ejecutar como: java org.transacciones_bancarias.main <ruta_archivo>");
            System.exit(
                    1);
        }

        String filePath = args[0];

        try{
            CsvTransactionRepository repository = new CsvTransactionRepository();
            TransactionService service = new TransactionService(repository);
            ConsoleReportAppareance appareance = new ConsoleReportAppareance();

            List<Transaction> transactions = repository.loadTransactions(filePath);
            TransactionReport report = service.generateReport(transactions);
            appareance.displayReport(report);
        } catch (ProcessingException e){
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}