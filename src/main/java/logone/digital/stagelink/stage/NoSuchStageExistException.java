package logone.digital.stagelink.stage;

public class NoSuchStageExistException extends RuntimeException {
    private String message;

    public NoSuchStageExistException() {}

    public NoSuchStageExistException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
