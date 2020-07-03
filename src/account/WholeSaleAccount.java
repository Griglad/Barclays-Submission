package account;
import product.Product;
import product.Tier1Capital;

import java.math.BigDecimal;

public class WholeSaleAccount extends Account {


    public WholeSaleAccount(String id) {
        super(id);
    }

    @Override
    public void addProduct(Product product) throws Exception {

        if (product instanceof Tier1Capital)
        {
            throw new Exception("Tier 1 Capital product can only be held by Internal Accounts");
        }
        super.addProduct(product);
    }

    @Override
    public void open() throws Exception {

        if (getBalance().compareTo(new BigDecimal(35000)) < 0) {
            throw new Exception("account.Account does not meet minimum balance of 35000 GBP");
        }
        super.open();
    }
}
