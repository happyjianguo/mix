public class StateTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 顺行起点A
        State state = new StateA();
        StateManager controller = new StateManager(state);
        for (int i = 0; i < 6; i++) {
            state = controller.nextState();

            System.out.print(state);
            if (state == null)
                break;
            System.out.print("->");
            // 顺流
            controller.nextStep();
        }

        System.out.println("");

        // 顺行起点D
        State converseState = new StateD();
        controller = new StateManager(converseState);
        for (int i = 0; i < 6; i++) {
            state = controller.nextState();

            System.out.print(state);
            if (state == null)
                break;
            System.out.print("->");
            // 逆流
            controller.lastStep();
        }
    }
}
