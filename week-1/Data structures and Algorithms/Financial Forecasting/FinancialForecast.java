import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FinancialForecast {

    // Recursive method with memoization
    public static double forecast(double initialValue, double rate, int years, Map<Integer, Double> memo) {
        if (years == 0) {
            return initialValue;
        }

        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        double result = forecast(initialValue, rate, years - 1, memo) * (1 + rate);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial investment amount: ");
        double initialInvestment = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g. 10%): ");
        double growthRate = scanner.nextDouble()/100;


        System.out.print("Enter number of years to forecast: ");
        int forecastYears = scanner.nextInt();

        Map<Integer, Double> memo = new HashMap<>();
        double futureValue = forecast(initialInvestment, growthRate, forecastYears, memo);

        System.out.printf("Future Value after "+forecastYears+" years: "+futureValue);
        
        scanner.close();
    }
}

