package product;

import util.ProductType;

import java.math.BigDecimal;

public class CollateralisedLoan extends Product {

    public CollateralisedLoan() {
        super("Collateralised Loan", ProductType.Liability, 3);
    }

    public CollateralisedLoan(BigDecimal amount){
        super("Collateralised Loan",ProductType.Liability,3,amount);
    }

    public CollateralisedLoan(double amount){
        super("Collateralised Loan",ProductType.Liability,3,amount);
    }


    public CollateralisedLoan(long amount){
        super("Collateralised Loan",ProductType.Liability,3,amount);
    }





}
