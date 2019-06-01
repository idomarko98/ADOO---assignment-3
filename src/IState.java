public interface IState {

    public void turnOn();

    public void turnOff();

    public void internetOn();

    public void internetOff();

    public void fileRequest();

    public void downloadAborted();

    public void downloadError();

    public void errorFixed();

    public void movieOn();

    public void restartMovie();

    public void holdMovie();

    public void movieOff();

    public void resume();

    public void entry();

    public void exit();

}
