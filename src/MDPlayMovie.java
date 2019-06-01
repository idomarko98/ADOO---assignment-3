public class MDPlayMovie extends MovieDisplayer {
    Thread timeCounter = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                //System.out.println(downloadQueue.isEmpty());
                while(true){
                    try {
                        Thread.sleep(1000);
                        context.playTime++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });


    public MDPlayMovie(Context context) {
        super(context);
        timeCounter.run();
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
        timeCounter.stop();
        On on = (On) context.currentState;
        on.exitState(this);
        on.setMovieDisplayer(new MDPauseMovie(context));
    }

    @Override
    public void movieOff() {

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
