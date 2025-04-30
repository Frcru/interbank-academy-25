package org.transacciones_bancarias.domain.model;

/**
 * Especifica los tipos de transacción.
 * Los tipos con CREDIT y DEBIT
 */
public enum TransactionType {
    CREDIT,DEBIT;

    /**
     *
     * @param type representa el tipo de transacción realizada.
     * @return el {@code TransactionType} correspondiente al enum ({@link #CREDIT} or {@link #DEBIT}).
     * @throws IllegalArgumentException si el String no coincide con caso Crédito o Débito.
     */
    public static TransactionType fromString(String type) {
        return switch (type) {
            case "Crédito" -> CREDIT;
            case "Débito" -> DEBIT;
            default -> throw new IllegalArgumentException("Tipo de transacción desconocido:" + type);
        };
    }

    /**
     * Retorna String, para pantalla usuario (terminal).
     * @return el String "Crédito" correspondiente a {@link #CREDIT} y "Débito" a {@link #DEBIT}.
     */
    @Override
    public String toString() {
        return switch (this) {
            case CREDIT -> "Crédito";
            case DEBIT -> "Débito";
        };
    }
}
