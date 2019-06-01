public class UMProfessional extends UserMonitor {

    private boolean keepListening;

    public UMProfessional(Context context) {
        super(context);

        context.downloadSpeed = 1.5;

        listenToPoints();
    }

    private void listenToPoints() {
        keepListening = true;
        Thread listenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(keepListening){
                    if(context.points < 7){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
        System.out.println("enter UserMonitor-Professional state");
    }

    @Override
    public void exit() {
        keepListening = false;
        System.out.println("exit UserMonitor-Professional state");
    }
}
