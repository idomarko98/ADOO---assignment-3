public class MDPauseMovie extends MovieDisplayer{
    private boolean alive = true;
    Thread timeCounter = new Thread(new Runnable() {
        @Override
        public void run() {
            while(alive){
                try {
                    Thread.sleep(1000);
                    if(context.percent==100){
                        movieOff();
                    }
                }
                catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
        }
    });
    Thread errorCounter = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                if(context.problemE){
                    movieOff();
                }
            }
            catch (InterruptedException e) {
                        e.printStackTrace();
            }
        }
    });

    public MDPauseMovie(Context context) {
        super(context);
        timeCounter.start();
        if(context.problemE)
            errorCounter.start();
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void internetOn() {
        context.problemI = false;
        try{
            Thread.sleep(1000);
        }
        catch(java.lang.InterruptedException e){
            e.printStackTrace();
        }
        this.resume();
    }

    @Override
    public void internetOff() {
        context.problemI = true;
    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {
        MDPlayMovie.isPaused = true;
        context.playTime = 0;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDIdle(context));
    }

    @Override
    public void downloadError() {
        context.problemE = true;
        errorCounter.start();
    }

    @Override
    public void errorFixed() {
        context.problemE = false;
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
        context.playTime = 0;
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDIdle(context));
    }

    @Override
    public void resume() {
        if(context.problemE || context.problemI){
            System.out.println("Cannot resume a movie while an error exists or internet is off!");
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
        alive = false;
        System.out.println("exit MovieDisplayer-Pause state");
    }
}
