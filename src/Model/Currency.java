package Model;

public class Currency {

    private String code;
    private String name;
    private String symbol;

    public Currency(String name, String code, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Currency(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
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
