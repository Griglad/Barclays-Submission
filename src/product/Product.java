package product;

import util.ProductType;

import java.math.BigDecimal;

public abstract class Product {

    private String name;
    private BigDecimal amount;
    private int riskRating;
    private ProductType type;

    public Product(String name, ProductType type, int riskRating) {
        this.name = name;
        this.type = type;
        this.riskRating = riskRating;
        this.amount = BigDecimal.ZERO;
    }


    public Product(String name,ProductType type, int riskRating,BigDecimal amount){
        this(name,type,riskRating);
        this.amount = amount;
    }

    public Product(String name,ProductType type, int riskRating,double amount){
        this(name,type,riskRating);
        this.amount = BigDecimal.valueOf(amount);
    }

    public Product(String name,ProductType type, int riskRating,long amount){
        this(name,type,riskRating);
        this.amount = BigDecimal.valueOf(amount);
    }







    public void setAmount(String amount) {

        this.amount = new BigDecimal(amount);
    }

    public void setAmount(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public void setAmount(long amount) {

        this.amount = BigDecimal.valueOf(amount);
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {

        return this.amount;
    }

    //SRWA = amount-((riskRating*0.5)*amount)
    public BigDecimal getSRWA() {
        BigDecimal temp = new BigDecimal(riskRating);
        temp = temp.multiply(BigDecimal.valueOf(0.05)).multiply(this.amount);
        return this.amount.subtract(temp);
    }

    public boolean isAsset() {

        return (this.type == ProductType.Asset);
    }

    public boolean isLiability() {

        return (this.type == ProductType.Liability);
    }

    public void printInfo() {
        System.out.println(this.name + ": " + this.amount);
    }

}
