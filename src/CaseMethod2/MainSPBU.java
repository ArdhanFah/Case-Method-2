package CaseMethod2;
import java.util.Scanner;

import CaseMethod2.Menu.MainMenu;

public class MainSPBU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        int pilihan;

        do {
            mainMenu.tampilkanMenu(); // Menu Utama
            pilihan = scanner.nextInt(); scanner.nextLine();
            mainMenu.prosesMenu(pilihan); // Switch Case unutk pilihan menu
        } while (pilihan != 0);
        
        scanner.close(); // Scanner Main Close 
        mainMenu.closeScanner(); // Scanner mainMenu Close. Supaya pada saat input data pada mainMenu Scanner tidak langsung menutup.
    }
}
