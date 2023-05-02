import java.util.Scanner;

public class BCCI_System {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ans;

        do {
            int sss_contri;
            double pag_ibig;
            double phil_health;
            double taxResult;
            double ms;
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("Name of Employee: ");
            input.nextLine();
            System.out.print("Name of Company: ");
            input.nextLine();
            System.out.print("Monthly Salary: ");
            ms = input.nextDouble();
            input.nextLine();

            // Income Tax
            taxResult = incomeTax(ms);
            System.out.printf("\n\tIncome Tax: %.2f", taxResult / 12);

            // SSS Contribution
            sss_contri = getSSSContribution(ms);
            System.out.printf("\n\tSSS Contribution: %d", sss_contri);

            // PAG-IBIG
            pag_ibig = getPagIbig(ms);
            System.out.printf("\n\tPAG-IBIG: %.0f", pag_ibig);

            // PHILHEALTH
            phil_health = getPhilHealth(ms);
            System.out.printf("\n\tPHIL-HEALTH: %.1f", phil_health);

            System.out.print("\n\nAnother Inquiry? (y/n): ");
            ans = input.nextLine().charAt(0);

        } while (ans == 'y' || ans == 'Y');

        input.close();
    }

    public static double incomeTax(double empSal) {
        double sal = empSal * 12;
        double resultTax = 0;
        
        if (sal < 250000) {
            resultTax = 0;
        } else if (sal >= 250000 && sal < 400000) {
            resultTax = (sal - 250000) * .20;
        } else if (sal >= 400000 && sal < 800000) {
            resultTax = (sal - 400000) * .25 + 30000;
        } else if (sal >= 800000 && sal < 2000000) {
            resultTax = (sal - 800000) * .30 + 130000;
        } else if (sal >= 2000000 && sal < 8000000) {
            resultTax = (sal - 2000000) * .32 + 490000;
        } else {
            resultTax = (sal - 8000000) * .35 + 2410000;
        }
        
        return resultTax;
    }

    public static int getSSSContribution(double ms) {
        int sss_contri = 0;
        
        if (ms < 2249.99) {
            sss_contri = 80;
        } else if (ms > 2250 && ms <= 2749.99) {
            sss_contri = 100;
        } else if (ms > 2750.00 && ms <= 3249.99) {
            sss_contri = 120;
        } else if (ms > 3250.00 && ms <= 3749.99) {
            sss_contri = 140;
        } else if (ms > 3750.00 && ms <= 4249.99) {
            sss_contri = 160;
        } else if (ms > 4250.00 && ms <= 4749.99) {
            sss_contri = 180;
        } else if (ms > 4750.00 && ms <= 5249.99) {
            sss_contri = 200;
        } else if (ms > 5250.00 && ms <= 5749.99) {
            sss_contri = 220;
        } else if (ms > 5750.00 && ms <= 6249.99) {
            sss_contri = 240;
        } else if (ms > 6250.00 && ms <= 6749.99) {
            sss_contri = 260;
        } else if (ms > 6750.00 && ms <= 7249.99) {
            sss_contri = 280;
        } else if (ms > 7250.00 && ms <= 7749.99) {
            sss_contri = 300;
        } else if (ms > 7750.00 && ms <= 8249.99) {
            sss_contri = 320;
        } else if (ms > 8250.00 && ms <= 8749.99) {
            sss_contri = 340;
        } else if (ms > 8750.00 && ms <= 9249.99) {
            sss_contri = 360;
        } else if (ms > 9250.00 && ms <= 9749.99) {
            sss_contri = 380;
        } else if (ms > 9750.00 && ms <= 10249.00) {
            sss_contri = 400;
        } else if (ms > 10250.00 && ms <= 10749.99) {
            sss_contri = 420;
        } else if (ms > 10750.00 && ms <= 11249.99) {
            sss_contri = 440;
        } else if (ms > 11250.00 && ms <= 11749.99) {
            sss_contri = 460;
        } else if (ms > 11750.00 && ms <= 12249.99) {
            sss_contri = 480;
        } else if (ms > 12250.00 && ms <= 12749.99) {
            sss_contri = 500;
        } else if (ms > 12750.00 && ms <= 13249.99) {
            sss_contri = 520;
        } else if (ms > 13250.00 && ms <= 13749.99) {
            sss_contri = 540;
        } else if (ms > 13750.00 && ms <= 14249.99) {
            sss_contri = 560;
        } else if (ms > 14250.00 && ms <= 14749.99) {
            sss_contri = 580;
        } else if (ms > 14750.00 && ms <= 15249.99) {
            sss_contri = 600;
        } else if (ms > 15250.00 && ms <= 15749.99) {
            sss_contri = 620;
        } else if (ms > 15750.00 && ms <= 16249.99) {
            sss_contri = 640;
        } else if (ms > 16250.00 && ms <= 16749.99) {
            sss_contri = 660;
        } else if (ms > 16750.00 && ms <= 17249.99) {
            sss_contri = 680;
        } else if (ms > 17250.00 && ms <= 17749.99) {
            sss_contri = 700;
        } else if (ms > 17750.00 && ms <= 18249.99) {
            sss_contri = 720;
        } else if (ms > 18250.00 && ms <= 18749.99) {
            sss_contri = 740;
        } else if (ms > 18750.00 && ms <= 19249.99) {
            sss_contri = 760;
        } else if (ms > 19250.00 && ms <= 19749.99) {
            sss_contri = 780;
        } else if (ms > 19750.00) {
            sss_contri = 800;
        }
        
        return sss_contri;
    }

    public static double getPagIbig(double ms) {
        double pag_ibig = 0.0;
        
        if (ms <= 1500) {
            pag_ibig = 0.1 * ms;
        } else if (ms > 1500) {
            pag_ibig = 0.2 * ms;
        } else {
            pag_ibig = 0;
        }
        
        return pag_ibig;
    }

    public static double getPhilHealth(double ms) {
        double phil_health = 0.0;
        
        if (ms <= 8999.99) {
            phil_health = 100;
        } else if (ms > 9000.00 && ms <= 9999.99) {
            phil_health = 112.50;
        } else if (ms > 10000.00 && ms <= 10999.99) {
            phil_health = 125.00;
        } else if (ms > 11000.00 && ms <= 11999.99) {
            phil_health = 137.50;
        } else if (ms > 12000.00 && ms <= 12999.99) {
            phil_health = 150.00;
        } else if (ms > 13000.00 && ms <= 13999.99) {
            phil_health = 162.50;
        } else if (ms > 14000.00 && ms <= 14999.99) {
            phil_health = 175.00;
        } else if (ms > 15000.00 && ms <= 15999.99) {
            phil_health = 187.50;
        } else if (ms > 16000.00 && ms <= 16999.99) {
            phil_health = 200.00;
        } else if (ms > 17000.00 && ms <= 17999.99) {
            phil_health = 212.50;
        } else if (ms > 18000.00 && ms <= 18999.99) {
            phil_health = 225.00;
        } else if (ms > 19000.00 && ms <= 19999.99) {
            phil_health = 237.50;
        } else if (ms > 20000.00 && ms <= 20999.99) {
            phil_health = 250.00;
        } else if (ms > 21000.00 && ms <= 21999.99) {
            phil_health = 262.50;
        } else if (ms > 22000.00 && ms <= 22999.99) {
            phil_health = 275.00;
        } else if (ms > 23000.00 && ms <= 23999.99) {
            phil_health = 287.50;
        } else if (ms > 24000.00 && ms <= 24999.99) {
            phil_health = 300.00;
        } else if (ms > 25000.00 && ms <= 25999.99) {
            phil_health = 312.50;
        } else if (ms > 26000.00 && ms <= 26999.99) {
            phil_health = 325.00;
        } else if (ms > 27000.00 && ms <= 27999.99) {
            phil_health = 337.50;
        } else if (ms > 28000.00 && ms <= 28999.99) {
            phil_health = 350.00;
        } else if (ms > 29000.00 && ms <= 29999.99) {
            phil_health = 362.50;
        } else if (ms > 30000.00 && ms <= 30999.99) {
            phil_health = 375.00;
        } else if (ms > 31000.00 && ms <= 31999.99) {
            phil_health = 387.50;
        } else if (ms > 32000.00 && ms <= 32999.99) {
            phil_health = 400.00;
        } else if (ms > 33000.00 && ms <= 33999.99) {
            phil_health = 412.50;
        } else if (ms > 34000.00 && ms <= 34999.99) {
            phil_health = 425.00;
        } else if (ms > 35000.00) {
            phil_health = 437.50;
        }
        
        return phil_health;
    }
}