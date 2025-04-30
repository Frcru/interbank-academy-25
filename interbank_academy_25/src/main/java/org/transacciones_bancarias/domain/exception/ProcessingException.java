package org.transacciones_bancarias.domain.exception;

/**
 * Personaliza las excepciones ocurridas en el proceso
 * ya sea por tipo data, parsing, validación
 *
 */
public class ProcessingException extends Exception{
    /**
     * Constructor con mensaje especificado
     * @param message detalle del mensaje
     */
    public ProcessingException(String message){
        super(message);
    }

    /**
     * Constructor con mensaje especificado y razón/causa
     *<p>nota: el mensaje detallado con  {@code cause} <i>no</i> está incorporado automáticamente en la excepción de mensaje detallado</p>
     * @param message el mensaje detallado que se desee
     * @param cause la causa que ha generado la excepción
     */
    public ProcessingException(String message, Throwable cause){
        super(message,cause);
    }
}
