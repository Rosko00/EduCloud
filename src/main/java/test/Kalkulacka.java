package test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Kalkulacka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        String pokracovat = " ";

        do {
            try {
                System.out.print("Zadajte prvé číslo: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Chyba: Zadajte platné číslo.");
                    sc.next();
                }
                double cislo1 = sc.nextDouble();

                System.out.print("Zadajte druhé číslo: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Chyba: Zadajte platné číslo.");
                    sc.next();
                }
                double cislo2 = sc.nextDouble();

                System.out.print("Vyberte operáciu (+, -, *, /): ");
                char operacia = sc.next().charAt(0);

                double vysledok = 0;
                switch (operacia) {
                    case '+':
                        vysledok = cislo1 + cislo2;
                        break;
                    case '-':
                        vysledok = cislo1 - cislo2;
                        break;
                    case '*':
                        vysledok = cislo1 * cislo2;
                        break;
                    case '/':
                        if (cislo2 != 0) {
                            vysledok = cislo1 / cislo2;
                        } else {
                            System.out.println("Chyba: Delenie nulou nie je povolené.");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Neplatná operácia.");
                        continue;
                }

                System.out.println("Výsledok: " + df.format(vysledok));
            } catch (Exception e) {
                System.out.println("Nastala chyba: " + e.getMessage());
                sc.nextLine(); // Preskočí chybný vstup
                continue;
            }

            System.out.print("Chcete pokračovať? (áno/nie): ");
            pokracovat = sc.next();

        } while (pokracovat.equalsIgnoreCase("áno"));

        sc.close();
        System.out.println("Koniec programu.");
    }
}
