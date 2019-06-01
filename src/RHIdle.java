public class RHIdle extends RequestHandler{
    public RHIdle(Context context) {
        super(context);
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void internetOn() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void fileRequest() {
        On on = (On)context.currentState;
        on.exitState(this);
        //on.setRequestHandler(new RHWorkRequest(context));
        new RHWorkRequest(context);
    }

    @Override
    public void downloadAborted() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void movieOn() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void entry() {
        System.out.println("enter RequestHandler-Idle state");
    }

    @Override
    public void exit() {
        System.out.println("exit RequestHandler-Idle state");
    }

}
