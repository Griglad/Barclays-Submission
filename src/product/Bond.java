package product;

import util.ProductType;

import java.math.BigDecimal;

public class Bond extends Product {

    public Bond() {
        super("Bond", ProductType.Asset, 1);

    }

    public Bond(BigDecimal amount) {
        super("Bond", ProductType.Asset,1,amount);

    }

    public Bond(double amount) {
        super("Bond", ProductType.Asset,1,amount);

    }

    public Bond(long amount) {
        super("Bond", ProductType.Asset,1,amount);

    }


}
