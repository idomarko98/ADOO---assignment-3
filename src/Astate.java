public abstract class Astate implements IState {

    Context context;

    public Astate(Context context){
        this.entry();
        this.context = context;
    }
}
