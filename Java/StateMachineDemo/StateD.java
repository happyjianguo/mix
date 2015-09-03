public class StateD implements State {

    //D->B
    public void lastStep(StateManager c) {
        // TODO Auto-generated method stub
        c.setState(new StateB());
    }

    //D->nlll(end)
    public void nextStep(StateManager c) {
        // TODO Auto-generated method stub
        c.setState(null);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "State D";
    }
}
