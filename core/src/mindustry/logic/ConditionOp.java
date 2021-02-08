package mindustry.logic;

public enum ConditionOp{
    等于("==", (a, b) -> Math.abs(a - b) < 0.000001, (a, b) -> a == b),
    不相等("not", (a, b) -> Math.abs(a - b) >= 0.000001, (a, b) -> a != b),
    少于("<", (a, b) -> a < b),
    少于等于("<=", (a, b) -> a <= b),
    大于(">", (a, b) -> a > b),
    大于等于(">=", (a, b) -> a >= b),
    总是("always", (a, b) -> true);

    public static final ConditionOp[] all = values();

    public final CondObjOpLambda objFunction;
    public final CondOpLambda function;
    public final String symbol;

    ConditionOp(String symbol, CondOpLambda function){
        this(symbol, function, null);
    }

    ConditionOp(String symbol, CondOpLambda function, CondObjOpLambda objFunction){
        this.symbol = symbol;
        this.function = function;
        this.objFunction = objFunction;
    }

    @Override
    public String toString(){
        return symbol;
    }

    interface CondObjOpLambda{
        boolean get(Object a, Object b);
    }

    interface CondOpLambda{
        boolean get(double a, double b);
    }
}
