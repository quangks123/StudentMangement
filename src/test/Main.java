
package test;

import controllers.StudentManager;
import views.MainMenu;

public class Main {
    public static void main(String[] args) {
        new StudentManager().initiate();
        String[] choices = {"Create", "View", "Find/Sort", "Update/Delete", "Report", "Exit"};
        new MainMenu("===== MENU =====", choices).run();
    }
}
