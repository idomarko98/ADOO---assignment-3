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
        MDPlayMovie.isPaused = true;
        //context.playTime = 0;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDIdle(context));
    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {
        context.problem = null;
        this.resume();
    }

    @Override
    public void movieOn() {

    }

    @Override
    public void restartMovie() {
        context.playTime = 0;
        this.resume();
    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {
        if(context.problem != null){
            System.out.println("Cannot resume a movie while an error exists!");
            return;
        }
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDPlayMovie(context));
    }

    @Override
    public void entry() {
        System.out.println("enter MovieDisplayer-Pause state");
    }

    @Override
    public void exit() {
        System.out.println("exit MovieDisplayer-Pause state");
    }
}
