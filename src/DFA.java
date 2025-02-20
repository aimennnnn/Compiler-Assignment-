import java.util.HashSet;
import java.util.Set;

public class DFA {
    private State startState;
    private final Set<State> states = new HashSet<>();

    public void addState(State state) {
        states.add(state);
    }

    public void setStartState(State startState) { this.startState = startState; }
    public State getStartState() { return startState; }
    public boolean isAcceptState(State state) { return state.isAccepting(); }

    public void printStateTable() {
        for (State state : states) {
            System.out.println("State " + state.getId() + " (Final: " + state.isAccepting() + ")");
            state.printTransitions();
        }
    }
}
