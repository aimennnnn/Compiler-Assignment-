import java.util.HashMap;
import java.util.Map;

public class State {
    private final int id;
    private final boolean isAccepting;
    private final Map<Character, State> transitions = new HashMap<>();

    public State(int id, boolean isAccepting) {
        this.id = id;
        this.isAccepting = isAccepting;
    }

    public void addTransition(char symbol, State to) {
        transitions.put(symbol, to);
    }

    public State getNextState(char symbol) {
        return transitions.get(symbol);
    }

    public int getId() { return id; }
    public boolean isAccepting() { return isAccepting; }

    public void printTransitions() {
        for (var entry : transitions.entrySet()) {
            System.out.println("On '" + entry.getKey() + "' -> State " + entry.getValue().getId());
        }
    }
}
