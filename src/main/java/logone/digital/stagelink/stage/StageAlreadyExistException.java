package logone.digital.stagelink.stage;


public class StageAlreadyExistException extends RuntimeException {

    private String message;

    public StageAlreadyExistException() {
    }

    public StageAlreadyExistException(String msg) {
        super(msg);
        this.message = msg;
    }
}