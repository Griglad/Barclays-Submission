import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private String id;
    private List<Product> products;
    private AccountState state;

    public Account(String id) {
        this.id = id;
        products = new ArrayList<>();
        this.state = AccountState.Initial;
    }

    public void addProduct(Product product) throws Exception {
        products.add(product);
    }


    public void open() throws Exception {
        this.state = AccountState.Open;
    }

    public BigDecimal getBalance() {

        return products.stream().map(Product::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public BigDecimal getAssets() {

        return products.stream().filter(Product::isAsset).map(Product::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getLiabilities() {

        return products.stream().filter(Product::isLiability).map(Product::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public BigDecimal getSRWA() {

        return products.stream().map(Product::getSRWA).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getId() {
        return id;
    }

    public void printInfo() {

        System.out.println("*** Account " + this.id + " ----------------------");
        products.forEach(Product::printInfo);
        System.out.println("-----------------------------------------");


    }
}
