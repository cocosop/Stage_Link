package logone.digital.stagelink.entreprise;

public class NoSuchEntrepriseExistException extends RuntimeException {

        private String message;

    public NoSuchEntrepriseExistException() {}

    public NoSuchEntrepriseExistException(String msg)
        {
            super(msg);
            this.message = msg;
        }
}
