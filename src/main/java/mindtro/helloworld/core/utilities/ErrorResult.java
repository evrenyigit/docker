package mindtro.helloworld.core.utilities;

public class ErrorResult extends Result{

    private Exception exception;

    public ErrorResult(){
        super(false);
    }

    public ErrorResult(Exception exception){
        super(false);
        this.exception = exception;
    }

}
