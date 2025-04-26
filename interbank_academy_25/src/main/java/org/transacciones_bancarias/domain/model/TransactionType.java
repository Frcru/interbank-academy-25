package org.transacciones_bancarias.domain.model;

public enum TransactionType {
    CREDIT,DEBIT;

    public static TransactionType fromString(String type) {
        return switch (type) {
            case "Crédito" -> CREDIT;
            case "Débito" -> DEBIT;
            default -> throw new IllegalArgumentException("Tipo de transacción desconocido:" + type);
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case CREDIT -> "Crédito";
            case DEBIT -> "Débito";
        };
    }
}
