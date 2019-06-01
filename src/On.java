import java.util.LinkedList;
import java.util.List;

public class On extends Astate implements IState {

    private RequestHandler requestHandler;
    private Downloader downloader;
    private MovieDisplayer movieDisplayer;
    private UserMonitor userMonitor;
    private static Downloader downloaderHistory = null;
    private List<Astate> states;


    public On(Context context){
        super(context);

        requestHandler = new RHIdle(context);
        if(downloaderHistory == null)
            downloader = new DownloaderIdle(context);
        else
            downloader = downloaderHistory;
        movieDisplayer = new MDIdle(context);
        userMonitor = new UMBeginner(context);

        states = new LinkedList<>();
        states.add(requestHandler);
        states.add(downloader);
        states.add(movieDisplayer);
        states.add(userMonitor);
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
        for(int i = 0; i <states.size(); i++){
            states.get(i).exit();
        }
        context.exitState();
        context.setCurrentState(new Off(context));
    }

    @Override
    public void internetOn() {

    }

    @Override
    public void internetOff() {

    }

    @Override
    public void fileRequest() {
        for(int i = 0; i <states.size(); i++){
            states.get(i).fileRequest();
        }
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
        System.out.println("Enter On state");
    }

    @Override
    public void exit() {
        System.out.println("Exit On state");
    }

    @Override
    public void downQueueNotEmpty() {
        for(int i = 0; i <states.size(); i++){
            states.get(i).downQueueNotEmpty();
        }
    }

    public void setState(Astate state, Astate newState){
        state = newState;
    }

    public void exitState(Astate state){
        state.exit();
    }
}
