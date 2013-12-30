package Model;

public class Currency {

    private final String code;
    private final String name;
    private String symbol;

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        if (symbol == null) {
            return code;
        } else {
            return symbol;
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

}

