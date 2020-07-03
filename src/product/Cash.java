package product;

import util.ProductType;

import java.math.BigDecimal;

public class Cash extends Product {

    public Cash() {
        super("Cash", ProductType.Asset, 2);
    }

    public Cash(BigDecimal amount) {
        super("Cash", ProductType.Asset, 2, amount);
    }

    public Cash(double amount) {
        super("Cash", ProductType.Asset, 2, amount);
    }

    public Cash(long amount) {
        super("Cash", ProductType.Asset, 2, amount);
    }

}
