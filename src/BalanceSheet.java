import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class BalanceSheet {

    private Map<String, Account> accounts = new HashMap<>();


    public void addAccount(Account account) throws Exception {

        if (accounts.containsKey(account.getId())) {
            throw new Exception("This account id already exists");
        }

        accounts.put(account.getId(), account);
    }

    public BigDecimal getNetWorthValue() {

        return accounts.entrySet().stream().map(e -> {
            BigDecimal bigDecimal = BigDecimal.ZERO;
           return bigDecimal.add(e.getValue().getAssets().subtract(e.getValue().getLiabilities()));
        }).reduce(BigDecimal.ZERO,BigDecimal::add);

    }

    public BigDecimal getSRWA() {

        return accounts.entrySet().stream().map(e->e.getValue().getSRWA()).reduce(BigDecimal.ZERO,BigDecimal::add);



    }

    public void printInfo() {

        accounts.forEach((key, value) -> value.printInfo());
    }
}
