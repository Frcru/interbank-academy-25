package org.transacciones_bancarias.presentation.console;

import org.transacciones_bancarias.application.dto.TransactionReport;

import java.io.PrintStream;

public class ConsoleReportAppareance {
    public void displayReport(TransactionReport report){
        PrintStream sys=System.out;
        sys.println("Reporte de Transacciones");
        sys.println("--------------------------------");
        sys.printf("Balance Final: %.2f%n",report.getFinalBalance());
        sys.printf("Transacción de Mayor monto: ID %s - %.2f%n",report.getHighestTransactionId(),report.getHighestTransactionAmount());
        sys.printf("Conteo de Transacciones: Crédito: %d Débito: %d%n",report.getCreditTransactionCount(),report.getDebitTransactionCount());
    }
}
