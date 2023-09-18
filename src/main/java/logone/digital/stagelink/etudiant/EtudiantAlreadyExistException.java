package logone.digital.stagelink.etudiant;

public class EtudiantAlreadyExistException extends RuntimeException{

    private String message;

    public EtudiantAlreadyExistException() {}

    public EtudiantAlreadyExistException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
