import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner scanner;

    static char[][] karte;
    static final int KARTE_GR = 3;
    static final char LEHR_PLATZ = '*';
    static final char X_PLATZ = 'X';
    static final char O_PLATZ = 'O';


    public static void main(String[] args) {
        karteIni();
        kartePrint();
        String first = name1();
        String second = name2();
        kartePrint();
        while (true) {
            spieler1(first);
            kartePrint();
            if (winCheck('X')) {
                System.out.println(first + " hat gewonnen!");
                break;
            }
            if (unen()) {
                System.out.println("Unentschieden");
                break;
            }
            spieler2(second);
            kartePrint();
            if (unen()) {
                System.out.println("Unentschieden");
                break;
            }
            if (winCheck('O')) {
                System.out.println(second + " hat gewonnen!");
                break;
            }
        }
    }

    public static boolean winCheck(char spielerZug) { //Win Test
        if (karte[0][0] == spielerZug && karte[0][1] == spielerZug && karte[0][2] == spielerZug) return true;
        if (karte[1][0] == spielerZug && karte[1][1] == spielerZug && karte[1][2] == spielerZug) return true;
        if (karte[2][0] == spielerZug && karte[2][1] == spielerZug && karte[2][2] == spielerZug) return true;

        if (karte[0][0] == spielerZug && karte[1][0] == spielerZug && karte[2][0] == spielerZug) return true;
        if (karte[0][1] == spielerZug && karte[1][1] == spielerZug && karte[2][1] == spielerZug) return true;
        if (karte[0][2] == spielerZug && karte[1][2] == spielerZug && karte[2][2] == spielerZug) return true;

        if (karte[0][0] == spielerZug && karte[1][1] == spielerZug && karte[2][2] == spielerZug) return true;
        if (karte[2][0] == spielerZug && karte[1][1] == spielerZug && karte[0][2] == spielerZug) return true;
        return false;
    }

    public static boolean unen() {  //Test für "Unenschieden"
        for (int i = 0; i < KARTE_GR; i++) {
            for (int j = 0; j < KARTE_GR; j++) {
                if (karte[i][j] == LEHR_PLATZ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean errorTest(int j) {    //Test ob Eingaben in richtigem Ramen sind
        if (j < 1 || j > 9) {
            System.out.println("Falsch! Bitte wählen zwischen 1 - 9");
            return false;
        }
        return true;
    }

    public static void spieler1(String name) {      //Zug von Spieler 1
        while (true) {
            System.out.println(name + " dein Zug!");
            int i;
            do {
                i = scanner.nextInt();
            } while (!errorTest(i));
            if (i == 7 && karte[0][0] == LEHR_PLATZ) { //darf kein Zug im belegten Platz haben
                karte[0][0] = X_PLATZ;
                break;
            }
            if (i == 8 && karte[0][1] == LEHR_PLATZ) {
                karte[0][1] = X_PLATZ;
                break;
            }
            if (i == 9 && karte[0][2] == LEHR_PLATZ) {
                karte[0][2] = X_PLATZ;
                break;
            }
            if (i == 4 && karte[1][0] == LEHR_PLATZ) {
                karte[1][0] = X_PLATZ;
                break;
            }
            if (i == 5 && karte[1][1] == LEHR_PLATZ) {
                karte[1][1] = X_PLATZ;
                break;
            }
            if (i == 6 && karte[1][2] == LEHR_PLATZ) {
                karte[1][2] = X_PLATZ;
                break;
            }
            if(i == 1 && karte[2][0] == LEHR_PLATZ) {
                karte[2][0] = X_PLATZ;
                break;
            }
            if(i == 2 && karte[2][1] == LEHR_PLATZ) {
                karte[2][1] = X_PLATZ;
                break;
            }
            if(i == 3 && karte[2][2] == LEHR_PLATZ) {
                karte[2][2] = X_PLATZ;
                break;
            }else{
                System.out.println("Platz ist besetzt! Neuer Versuch: ");
            }
        }
    }
    public static void spieler2(String name) {      //Zug von Spieler 2
        while (true) {
            System.out.println(name + " dein Zug!");
            int i;
            do {
                i = scanner.nextInt();
            } while (!errorTest(i));
            if (i == 7 && karte[0][0] == LEHR_PLATZ) { //darf kein Zug im belegten Platz haben
                karte[0][0] = O_PLATZ;
                break;
            }
            if (i == 8 && karte[0][1] == LEHR_PLATZ) {
                karte[0][1] = O_PLATZ;
                break;
            }
            if (i == 9 && karte[0][2] == LEHR_PLATZ) {
                karte[0][2] = O_PLATZ;
                break;
            }
            if (i == 4 && karte[1][0] == LEHR_PLATZ) {
                karte[1][0] = O_PLATZ;
                break;
            }
            if (i == 5 && karte[1][1] == LEHR_PLATZ) {
                karte[1][1] = O_PLATZ;
                break;
            }
            if (i == 6 && karte[1][2] == LEHR_PLATZ) {
                karte[1][2] = O_PLATZ;
                break;
            }
            if(i == 1 && karte[2][0] == LEHR_PLATZ) {
                karte[2][0] = O_PLATZ;
                break;
            }
            if(i == 2 && karte[2][1] == LEHR_PLATZ) {
                karte[2][1] = O_PLATZ;
                break;
            }
            if(i == 3 && karte[2][2] == LEHR_PLATZ) {
                karte[2][2] = O_PLATZ;
                break;
            }else{
                System.out.println("Platz ist besetzt! Neuer Versuch: ");
            }
        }
    }
    public static String name1(){
        System.out.println("Spieler 1 name ✎ "); //Initialisierung von Spieler 1
        String name1 = scanner.nextLine();
        return name1;
    }
    public static String name2(){
        System.out.println("Spieler 2 name ✎ ");//Initialisierung von Spieler 2
        String name2 = scanner.nextLine();
        return name2;
    }
    public static void kartePrint() {
        System.out.println("ナίℂ ナαℂ ナ٥℮");
        //Aussehen von Spalten
        System.out.println("");
        System.out.println(" ▇-" +  karte[0][0] + "  " + karte[0][1] + "  " + karte[0][2] + "-▇ " );
        System.out.println(" ▇-" +  karte[1][0] + "  " + karte[1][1] + "  " + karte[1][2] + "-▇ ");
        System.out.println(" ▇-" +  karte[2][0] + "  " + karte[2][1] + "  " + karte[2][2] + "-▇ ");
        System.out.println(" ▇▆▅▄▃▂▃▄▅▆▇ ");
    }
    public static void karteIni(){
        karte = new char[KARTE_GR][KARTE_GR]; //Inhalt Spalten
        for (int i = 0; i < KARTE_GR; i++) {
            for (int j = 0; j < KARTE_GR; j++) {
                karte[i][j] = LEHR_PLATZ;
            }
        }
        scanner = new Scanner(System.in);
    }
}

