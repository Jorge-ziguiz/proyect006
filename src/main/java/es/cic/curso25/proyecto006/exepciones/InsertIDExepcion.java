package es.cic.curso25.proyecto006.exepciones;

public class InsertIDExepcion extends RuntimeException{

    public InsertIDExepcion(String message, Throwable Cause){
        super(message,Cause);
    }

    public InsertIDExepcion(Throwable Cause){
        super(Cause);
    }




}
