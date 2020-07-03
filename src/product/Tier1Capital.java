package product;

import product.Product;
import util.ProductType;

import java.math.BigDecimal;

public class Tier1Capital extends Product {

    public Tier1Capital() {
        super("Tier 1 Capital", ProductType.Asset, 0);
    }

    public Tier1Capital(BigDecimal amount) {
        super("Tier 1 Capital", ProductType.Asset, 0,amount);
    }

    public Tier1Capital(double amount) {
        super("Tier 1 Capital", ProductType.Asset, 0,amount);
    }

    public Tier1Capital(long amount) {
        super("Tier 1 Capital", ProductType.Asset, 0,amount);
    }
}
