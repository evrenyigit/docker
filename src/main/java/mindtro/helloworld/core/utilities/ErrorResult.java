package mindtro.helloworld.core.utilities;

public class ErrorResult extends Result{

    private Exception exception;

    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message){
        super(false,message);
    }

}
