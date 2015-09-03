public interface State {
    // 执行'上一步' 操作
    public void lastStep(StateManager c);

    // 执行'下一步' 操作
    public void nextStep(StateManager c);
}
