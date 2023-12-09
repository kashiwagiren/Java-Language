import java.util.Scanner;

public class BCCI_System {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ans;

        do {
            int sssContri;
            double pagIbig, philHealth, taxResult, monthlySalary;
            
            System.out.print("Name of Employee: ");
            input.nextLine();
            System.out.print("Name of Company: ");
            input.nextLine();
            System.out.print("Monthly Salary: ");
            monthlySalary = input.nextDouble();
            input.nextLine();

            taxResult = incomeTax(monthlySalary);
            System.out.printf("\n\tIncome Tax: %.2f", taxResult / 12);

            sssContri = getSSSContribution(monthlySalary);
            System.out.printf("\n\tSSS Contribution: %d", sssContri);

            pagIbig = getPagIbig(monthlySalary);
            System.out.printf("\n\tPag-Ibig: %.0f", pagIbig);

            philHealth = getPhilHealth(monthlySalary);
            System.out.printf("\n\tPhil-Health: %.1f", philHealth);

            System.out.print("\n\nAnother Inquiry? (y/n): ");
            ans = input.nextLine().charAt(0);
        } while (ans == 'y' || ans == 'Y');

        input.close();
    }

    static double incomeTax(double monthlySalary) {
        double annualSalary = monthlySalary * 12;

        if (annualSalary < 250000) {
            return 0;
        }
        if (annualSalary < 400000) {
            return (annualSalary - 250000) * .20;
        }
        if (annualSalary < 800000) {
            return (annualSalary - 400000) * .25 + 30000;
        }
        if (annualSalary < 2000000) {
            return (annualSalary - 800000) * .30 + 130000;
        }
        if (annualSalary < 8000000) {
            return (annualSalary - 2000000) * .32 + 490000;
        }
        return (annualSalary - 8000000) * .35 + 2410000;
    }

    static int getSSSContribution(double monthlySalary) {
        if (monthlySalary < 2249.99) return 80;
        if (monthlySalary > 19750) return 800;

        return 100 + (int)((monthlySalary - 2250) / 500) * 20;
    }

    static double getPagIbig(double monthlySalary) {
        return monthlySalary <= 1500 ? 0.1 * monthlySalary : 0.2 * monthlySalary;
    }

    static double getPhilHealth(double monthlySalary) {
        if (monthlySalary <= 8999.99) return 100.0;
        if (monthlySalary > 35000.00) return 437.50;

        return 112.50 + (int)((monthlySalary - 9000) / 1000) * 12.50;
    }
}
