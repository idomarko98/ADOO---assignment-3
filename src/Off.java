public class Off extends Astate implements IState {

    public  Off(Context context){
        super(context);
    }

    @Override
    public void turnOn() {
        context.exitState();
        context.setCurrentState(new On(this.context));
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
        System.out.println("Enter Off state");
    }

    @Override
    public void exit() {
        System.out.println("Exit Off state");
    }

    @Override
    public void downQueueNotEmpty() {

    }


}
