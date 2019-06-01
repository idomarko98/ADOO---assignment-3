public class MDPauseMovie extends MovieDisplayer{

    public MDPauseMovie(Context context) {
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
        context.problem = null;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDPlayMovie(context));
    }

    @Override
    public void movieOn() {

    }

    @Override
    public void restartMovie() {
        context.playTime = 0;
    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDPlayMovie(context));
    }

    @Override
    public void entry() {
        System.out.println("Enter MovieDisplayer-Pause state");
    }

    @Override
    public void exit() {
        System.out.println("Exit MovieDisplayer-Pause state");
    }
}
