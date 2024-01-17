package logone.digital.stagelink.etudiant;

public class NoSuchEtudiantExistException extends RuntimeException{
    private String message;

    public NoSuchEtudiantExistException() {}

    public NoSuchEtudiantExistException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
