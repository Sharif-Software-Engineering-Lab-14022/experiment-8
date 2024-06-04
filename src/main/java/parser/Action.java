package parser;

public class Action {
    private act action;
    //if action = shift : number is state
    //if action = reduce : number is number of rule
    public int number;

    public Action(act action, int number) {
        this.action = action;
        this.number = number;
    }

    public act getAction() {
        return action;
    }

    public String toString() {
        switch (action) {
            case accept:
                return "acc";
            case shift:
                return "s" + number;
            case reduce:
                return "r" + number;
        }
        return action.toString() + number;
    }
}

enum act {
    shift, reduce, accept
}
