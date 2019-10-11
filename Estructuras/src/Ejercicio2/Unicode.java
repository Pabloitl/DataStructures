package Ejercicio2;

import java.util.Scanner;

public class Unicode {
    int li, ls, opt;

    public static void main(String[] args) {
        Unicode test = new Unicode();
        Scanner in = new Scanner(System.in);
        test.meta();
        System.out.print("Menú:\n"
                + "1.- Control codes\n"
                + "2.- Basic latin\n"
                + "3.- Latin1 supplement\n"
                + "4.- Latin extended-A\n"
                + "5.- Latin extended-B\n"
                + "6.- Latin extended additional\n"
                + "7.- IPA exntensions\n"
                + "8.- Spacing modifier letters\n"
                + "9.- Greek and Coptic\n"
                + "10.- Greek extended\n"
                + "11.- Cyrilic\n"
                + "12.- Unicode symbols\n"
                + "13.- General punctuation\n"
                + "14.- Superscripts and subscripts\n"
                + "15.- Currency symbols\n"
                + "16.- Letterlike symbols\n"
                + "17.- Number forms\n"
                + "18,- Arrows\n"
                + "19.- Mathematical symbols\n"
                + "20.- Miscellaneous technical\n"
                + "21.- Enclosed alphanumerics\n"
                + "22.- Box drawing\n"
                + "23.- Block element\n"
                + "24.- Geometric shapes\n"
                + "25.- Miscellaneous symbols\n"
                + "Cualquier otro número.- Rando personalizado >> ");
        test.opt = in.nextInt();
        test.calculos();
        test.resultados();
    }

    public void meta() {
        System.out.println("Visualizar ssegmentos de la tabla unicode"
                + "conforme a un límite inferior y límite superior");
    }

    public void datos() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingresa límite inferior: ");
        li = in.nextInt();
        System.out.print("Ingresa límite superior: ");
        ls = in.nextInt();
    }

    public void calculos() {
        switch(opt) {
            case 1:  li = 0;      ls = 159;    break;
            case 2:  li = 32;     ls = 126;    break;
            case 3:  li = 160;    ls = 255;    break;
            case 4:  li = 256;    ls = 383;    break;
            case 5:  li = 384;    ls = 591;    break;
            case 6:  li = 0x1E02; ls = 0x1EF3; break;
            case 7:  li = 601;    ls = 658;    break;
            case 8:  li = 688;    ls = 767;    break;
            case 9:  li = 880;    ls = 1023;   break;
            case 10: li = 0x1F00; ls = 0x1FFE; break;
            case 11: li = 0x400;  ls = 0x4FF;  break;
            case 12: li = 0x2013; ls = 0x204A; break;
            case 13: li = 0x2000; ls = 0x206D; break;
            case 14: li = 0x2070; ls = 0x209C; break;
            case 15: li = 0x20A0; ls = 0x20BF; break;
            case 16: li = 0x2100; ls = 0x214F; break;
            case 17: li = 0x2150; ls = 0x218B; break;
            case 18: li = 0x2190; ls = 0x21FF; break;
            case 19: li = 0x2200; ls = 0x22FF; break;
            case 20: li = 0x2300; ls = 0x23FF; break;
            case 21: li = 0x2460; ls = 0x34FF; break;
            case 22: li = 0x2500; ls = 0x257F; break;
            case 23: li = 0x2580; ls = 0x259F; break;
            case 24: li = 0x25A0; ls = 0x25FF; break;
            case 25: li = 0x2600; ls = 0x26FF; break;
            default: datos();
        }
    }

    public void resultados() {
        for(int c = li; c < ls; c++) {
            System.out.printf("%d -> %c\n", c, c);
        }
    }
}
