package product;

import util.ProductType;

import java.math.BigDecimal;

public class CollateralizedLoan extends Product {

    public CollateralizedLoan() {
        super("Collateralized Loan", ProductType.Liability, 3);
    }

    public CollateralizedLoan(BigDecimal amount){
        super("Collateralized Loan",ProductType.Liability,3,amount);
    }

    public CollateralizedLoan(double amount){
        super("Collateralized Loan",ProductType.Liability,3,amount);
    }


    public CollateralizedLoan(long amount){
        super("Collateralized Loan",ProductType.Liability,3,amount);
    }





}
