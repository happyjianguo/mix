public class StateB implements State {

    //B->A
    public void lastStep(StateManager c) {
        // TODO Auto-generated method stub
        c.setState(new StateA());
    }

    //B->C
    public void nextStep(StateManager c) {
        // TODO Auto-generated method stub
        c.setState(new StateC());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "State B";
    }

}
