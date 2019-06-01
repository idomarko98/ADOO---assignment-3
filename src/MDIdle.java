public class MDIdle extends MovieDisplayer{

    public MDIdle(Context context) {
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
        if(context.percent >= 20){
            On on = (On)context.currentState;
            on.exitState(this);
            on.setMovieDisplayer(new MDPlayMovie(context));
        }
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
        System.out.println("enter MovieDisplayer-Idle state");
    }

    @Override
    public void exit() {
        System.out.println("exit MovieDisplayer-Idle state");
    }
}
