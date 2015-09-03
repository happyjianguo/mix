public class StateA implements State {

    // A->C
    public void lastStep(StateManager c) {
        // TODO Auto-generated method stub
        c.setState(new StateC());
    }

    // A->B
    public void nextStep(StateManager c) {
        // TODO Auto-generated method stub
        c.setState(new StateB());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "State A";
    }

}
