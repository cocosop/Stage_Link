package logone.digital.stagelink.entreprise;

public class EntrepriseAlreadyExistsException extends RuntimeException {

    private String message;

    public EntrepriseAlreadyExistsException() {}

    public EntrepriseAlreadyExistsException(String msg)
        {
            super(msg);
            this.message = msg;
        }
}
