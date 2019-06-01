public class MDPlayMovie extends MovieDisplayer {
    static public boolean isPaused = false;
    Thread timeCounter = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                    if(isPaused)
                        context.playTime++;
                    if(context.percent==100){
                        movieOff();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });


    public MDPlayMovie(Context context) {
        super(context);
        isPaused = false;
        timeCounter.start();
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
        context.problem = "internet";
        this.holdMovie();
    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {
        context.percent = 0;
        movieOff();
    }

    @Override
    public void downloadError() {
        context.problem = "error";
        this.holdMovie();
    }

    @Override
    public void errorFixed() {

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
        isPaused = true;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDPauseMovie(context));
    }

    @Override
    public void movieOff() {
        isPaused = true;
        context.playTime = 0;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDIdle(context));

    }

    @Override
    public void resume() {

    }

    @Override
    public void entry() {
        System.out.println("enter MovieDisplayer-Play state");
    }

    @Override
    public void exit() {
        System.out.println("exit MovieDisplayer-Play state");
    }
}
