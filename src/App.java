import account.InternalAccount;
import account.WholeSaleAccount;
import balancesheet.BalanceSheet;
import product.*;
import util.AccountProvider;

import java.util.Random;
import java.util.Scanner;


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
            int min = 100000;
            int max = 200000;
            int base = (max - min) + 1;

            account = new InternalAccount(AccountProvider.getRandomString());
            for (int i = 0; i < 10; i++) {

                product = new CollateralisedLoan();
                product.setAmount(rand.nextInt(base) + min);

                account.addProduct(product);
            }

            account.open();
            bs.addAccount(account);

            // 10 Wholesale accounts, each holding a cash product of value between 10,000 and
            //100,000 GBP, also containing two bond products with values in the same range
            min = 10000;
            max = 100000;
            base = (max - min) + 1;

            for (int i = 0; i < 10; i++) {

                WholeSaleAccount whacc = new WholeSaleAccount(AccountProvider.getRandomString());

                product = new Cash();
                product.setAmount(rand.nextInt(base) + min);
                whacc.addProduct(product);

                product = new Bond();
                product.setAmount(rand.nextInt(base) + min);
                whacc.addProduct(product);

                product = new Bond();
                product.setAmount(rand.nextInt(base) + min);
                whacc.addProduct(product);

                whacc.open();
                bs.addAccount(whacc);
            }

            // Show list of accounts
            //
            bs.printInfo();

            // Net Worth Value
            //
            System.out.println("Net worth Value");
            System.out.println(bs.getNetWorthValue());

            // SRWA
            //
            System.out.println("----SRWA----");
            System.out.println("SRWA: " + bs.getSRWA());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }





}
