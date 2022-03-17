import account.Account;
import account.InternalAccount;
import account.WholeSaleAccount;
import balancesheet.BalanceSheet;
import product.*;
import util.AccountProvider;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;


public class App {


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            BalanceSheet bs = new BalanceSheet();


            // An Internal account containing 10 billion GBP
            // of Tier 1 capital.
            Product product = new Tier1Capital();
            product.setAmount(10000000000L);

            InternalAccount account = new InternalAccount(AccountProvider.getRandomString());
            account.addProduct(product);
            account.open();
            bs.addAccount(account);

            // An Internal account holding 10 Collateralised loans each one of an amount between
            // 100,000 and 200,000 GBP
            Random rand = new Random();


           

            IntStream.rangeClosed(1, 10).forEach(e -> {
                int min = 100000;
                int max = 200000;
                int base = (max - min) + 1;
                Product p = new CollateralizedLoan();
                p.setAmount(rand.nextInt(base) + min);
                try {
                    Account internalAccount = new InternalAccount((AccountProvider.getRandomString()));
                    internalAccount.addProduct(p);
                    internalAccount.open();
                    bs.addAccount(internalAccount);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });


            IntStream.rangeClosed(1, 10).forEach(e -> {
                int min = 10000;
                int max = 100000;
                int base = (max - min) + 1;
                WholeSaleAccount whacc = new WholeSaleAccount(AccountProvider.getRandomString());
                Product cash = new Cash();
                Product bond1 = new Bond();
                Product bond2 = new Bond();
                try {
                    cash.setAmount(rand.nextInt(base) + min);
                    whacc.addProduct(cash);
                    bond1.setAmount(rand.nextInt(base) + min);
                    whacc.addProduct(bond1);
                    bond2.setAmount(rand.nextInt(base) + min);
                    whacc.addProduct(bond2);
                    whacc.open();
                    bs.addAccount(whacc);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // Show list of accounts
                //

            });
            bs.printInfo();

            // Net Worth Value
            //
            System.out.println("----Net worth Value----");
            System.out.println("NW:" + bs.getNetWorthValue());

            // SRWA
            //
            System.out.println("----SRWA----");
            System.out.println("SRWA:" + bs.getSRWA());





        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
