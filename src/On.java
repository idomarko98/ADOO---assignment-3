import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

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
        if(downloaderHistory == null || downloaderHistory instanceof DownloaderIdle)
            downloader = new DownloaderIdle(context);
        else {
            if(downloaderHistory instanceof  DownloaderDownload)
                downloader = new DownloaderDownload(context);
            else if(downloaderHistory instanceof  DownloaderError)
                downloader = new DownloaderError(context);
            else if (downloaderHistory instanceof DownloaderHold)
                downloader = new DownloaderHold(context);
            else if(downloaderHistory instanceof DownloaderPreDownload)
                downloader = new DownloaderPreDownload(context);
            else if(downloaderHistory instanceof  DownloaderWait)
                downloader = new DownloaderWait(context);
        }
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
        for(int i = 0; i <states.size(); i++){
            states.get(i).internetOn();
        }
    }

    @Override
    public void internetOff() {
        for(int i = 0; i <states.size(); i++){
            states.get(i).internetOff();
        }
    }

    @Override
    public void fileRequest() {
        for(int i = 0; i <states.size(); i++){
            states.get(i).fileRequest();
        }
    }

    @Override
    public void downloadAborted() {
        for(int i = 0; i <states.size(); i++){
            states.get(i).downloadAborted();
        }
    }

    @Override
    public void downloadError() {
        for(int i = 0; i <states.size(); i++){
            states.get(i).downloadError();
        }
    }

    @Override
    public void errorFixed() {
        for(int i = 0; i <states.size(); i++){
            states.get(i).errorFixed();
        }
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

    /*public void setState(Astate state, Astate newState){
        state = newState;
    }*/

    public void setDownloader(Downloader state){
        for(int i = 0; i < states.size(); i++){
            if(states.get(i) instanceof  Downloader) {
                states.remove(i);
                states.add(i, state);
                downloader = state;
                downloaderHistory = state;
            }
        }
    }

    public void setRequestHandler(RequestHandler state){
        for(int i = 0; i < states.size(); i++){
            if(states.get(i) instanceof  RequestHandler) {
                states.remove(i);
                states.add(i, state);
                requestHandler = state;
            }
        }
    }

    public void setMovieDisplayer(MovieDisplayer state){
        for(int i = 0; i < states.size(); i++){
            if(states.get(i) instanceof  MovieDisplayer) {
                states.remove(i);
                states.add(i, state);
                movieDisplayer = state;
            }
        }
    }

    public void setUserMonitor(UserMonitor state){
        for(int i = 0; i < states.size(); i++){
            if(states.get(i) instanceof  UserMonitor) {
                states.remove(i);
                states.add(i, state);
                userMonitor = state;
            }
        }
    }

    public void exitState(Astate state){
        state.exit();
    }

    public Downloader getDownloader() {
        return downloader;
    }
}
