public class UMBeginner extends UserMonitor{

    private boolean keepListening;

    public UMBeginner(Context context) {
        super(context);

        listenToPoints();
    }

    private void listenToPoints() {
        keepListening = true;
        Thread listenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(keepListening){
                    if(context.points >= 4){
                        moveToAdvance();
                    }
                }
            }
        });

        listenThread.start();
    }

    private void moveToAdvance() {
        On on = (On) context.currentState;
        on.exitState(this);
        on.setUserMonitor(new UMAdvance(context));
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
        System.out.println("enter UserMonitor-Beginner state");
    }

    @Override
    public void exit() {
        keepListening = false;
        System.out.println("exit UserMonitor-Beginner state")
        ;
    }

}
