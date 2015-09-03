public class StateC implements State {

    //C->null(end)
    public void lastStep(StateManager c) {
        // TODO Auto-generated method stub
        c.setState(null);
    }

    //C->D
    public void nextStep(StateManager c) {
        // TODO Auto-generated method stub
        c.setState(new StateD());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "State C";
    }
}
