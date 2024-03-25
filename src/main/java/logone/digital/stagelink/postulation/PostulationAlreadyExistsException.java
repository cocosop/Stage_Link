package logone.digital.stagelink.postulation;

public class PostulationAlreadyExistsException extends RuntimeException {
    private String message;
    public PostulationAlreadyExistsException() {}
    public PostulationAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
