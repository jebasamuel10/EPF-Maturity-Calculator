package com.jeba.tools.epf;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Double interestRate = Double.valueOf( args[0]);//epf intrest rate
        Integer tenure = Integer.valueOf(args[1]);//no.of.years remaining for maturity
        Double lumpSum = Double.valueOf(args[2]);//lumpsum amount already available.
        Double mtlyContribution = Double.valueOf(args[3]);//lumpsum amount already available.
        System.out.println("Please wait while I calculate your retirement corpus.. Interest rate:"+interestRate+" " +
                " Tenure :"+tenure+" lumpsum that you already have:"+lumpSum+" Monthly contribution going forward"+mtlyContribution);
        System.out.println("Your Maturity Amount after 10 years would be:"+calcMaturityAmount(interestRate,tenure,lumpSum,mtlyContribution));
    }

    private static Double calcMaturityAmount(Double interestRate, Integer tenure, Double lumpSum,Double mtlyContribution) {
        Double accumulatedAmount = lumpSum;
        for (int i=1;i<=tenure;i++){
            for(int j=1;j<=12;j++){
                Double yearlyInterest = (accumulatedAmount*interestRate) / 100;
                Double monthlyInterest = (yearlyInterest/12);
                accumulatedAmount = accumulatedAmount + monthlyInterest + (mtlyContribution*2);
            }
        }
        return accumulatedAmount;
    }
}
