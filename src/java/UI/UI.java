package UI;

import SwitchSchool.SwitchSchool;

import java.util.List;

import javax.swing.JOptionPane;

/*Author:     Ghulam Murtaza
    
 */
public class UI {                           // Class for user tier

    static SwitchSchool SW = new SwitchSchool();
    static int val;
    static String input = null;
    String[] s = new String[15];

    public static int mainMenu() {

        input = JOptionPane.showInputDialog("****************MAIN MENU**************\n\n"
                + " Welcome to SchoolManagmentSystem \n 1: School Management \n "
                + "2: School Statistics \n 0: Exit \n\n ********************************************   ");

        val = readNumber(input);
        SW.SwitchMainMenu(val);
        return val;
    }

    public int managementMenu() {

        s[0] = "****************Management System*****************";
        s[1] = "1.Register/Add Entity";
        s[2] = "2.Find Entity";
        s[3] = "3.Update Entity";
        s[4] = "4.Remove Entity";
        s[5] = "0.Back to main menu";
        s[6] = "*********************************************************";
        input = JOptionPane.showInputDialog(s[0] + "\n" + s[1] + "\n" + s[2] + "\n" + s[3] + "\n" + s[4] + "\n" + s[5] + "\n" + s[6] + "\nChoose above what you want to do...");
        val = readNumber(input);
        SW.SwitchManagement(val);
        return val;

    }

    public int regMenu() {

        s[0] = "**************Register Menu**************";
        s[1] = "1. Register a new Student";
        s[2] = "2. Register a new Teacher";
        s[3] = "3. Add a Teacher to a course";
        s[4] = "4. Register a new Education";
        s[5] = "5. Register a new Course";
        s[6] = "6. Add a course to an Education";
        s[7] = "0. Back to previous menu";
        s[8] = "*****************************************";
        input = JOptionPane.showInputDialog(s[0] + "\n" + s[1] + "\n" + s[2] + "\n" + s[3] + "\n" + s[4] + "\n" + s[5] + "\n" + s[6] + "\n" + s[7] + "\n" + s[8] + "\nChoose above what you want to do...");
        val = readNumber(input);
        SW.SwitchRegister(val);
        return val;
    }

    public int findMenu() {

        s[0] = "**************Information Menu**************";
        s[1] = "1.Find all Students";
        s[2] = "2.Find Student by ID";
        s[3] = "3.Find Student by Name";
        s[4] = "4.Find Students by Course";
        s[5] = "5.Find Students by Education";
        s[6] = "6.Find all Teachers";
        s[7] = "7.Find Teacher by ID";
        s[8] = "8.Find Teacher by Name";
        s[9] = "9.Find Teachers by Course";
        s[10] = "10.Find Teachers by Education";
        s[11] = "11.Find all Courses";
        s[12] = "12.Find all Educations";
        s[13] = "0. Back to previous menu";
        s[14] = "********************************************";
        input = JOptionPane.showInputDialog(s[0] + "\n" + s[1] + "\n" + s[2] + "\n" + s[3] + "\n" + s[4] + "\n"
                + s[5] + "\n" + s[6] + "\n" + s[7] + "\n" + s[8] + "\n" + s[9] + "\n" + s[10] + "\n" + s[11] + "\n" + s[12] + "\n" + s[13] + "\n" + s[14] + "\nChoose above what you want to do...");
        val = readNumber(input);
        SW.SwitchFind(val);
        return val;
    }

    public int updateMenu() {

        s[0] = "*************Update Menu**************";
        s[1] = "1.Update Students name";
        s[2] = "2.Update Teachers name";
        s[3] = "3.Update students education";
        s[4] = "4.Update teacher course";
        s[5] = "0.Back to previous menu";
        s[6] = "****************************************";
        input = JOptionPane.showInputDialog(s[0] + "\n" + s[1] + "\n" + s[2] + "\n" + s[3] + "\n" + s[4] + "\n"
                + s[5] + "\n" + s[6] + "\nChoose above what you want to do...");
        val = readNumber(input);
        SW.SwitchUpdate(val);
        return val;
    }

    public int removeMenu() {

        s[0] = "*************Remove Menu**************";
        s[1] = "1.Remove Student";
        s[2] = "2.Remove Teacher";
        s[3] = "3.Remove Course";
        s[4] = "4.Remove Education";
        s[5] = "0. Back to previous menu";
        s[6] = "***************************************";
        input = JOptionPane.showInputDialog(s[0] + "\n" + s[1] + "\n" + s[2] + "\n" + s[3] + "\n" + s[4] + "\n"
                + s[5] + "\n" + s[6] + "\nChoose above what you want to do...");
        val = readNumber(input);
        SW.SwitchRemove(val);
        return val;
    }

    public int SchoolStatistics() {

        s[0] = "**************Statistics Menu***************";
        s[1] = "1.Total Students";
        s[2] = "2.Total Teachers";
        s[3] = "3.Total Courses";
        s[4] = "4.Total Educations";
        s[5] = "5.Total Male Students/Teachers";
        s[6] = "6.Total Female Students/Teacher";
        s[7] = "7.Avarage age of Students/Teachers";
        s[8] = "8.Highest age of Student/Teacher";
        s[9] = "9.Lowest age of Student/Teacher";
        s[10] = "0.Back to Main menu";
        s[11] = "*********************************************";
        input = JOptionPane.showInputDialog(s[0] + "\n" + s[1] + "\n" + s[2] + "\n" + s[3] + "\n" + s[4] + "\n"
                + s[5] + "\n" + s[6] + "\n" + s[7] + "\n" + s[8] + "\n" + s[9] + "\n" + s[10] + "\n" + s[11] + "\nChoose above what you want to do...");
        val = readNumber(input);
        SW.SwitchStats(val);
        return val;
    }

    public String enterName() {
        input = JOptionPane.showInputDialog("Enter name:");
        return readText(input);
    }

    public String enterGender() {
        input = JOptionPane.showInputDialog("Enter gender:");
        return readText(input);
    }

    public int enterAge() {
        input = JOptionPane.showInputDialog("Enter age:");
        return readNumber(input);
    }

    public int enterId() {

        input = JOptionPane.showInputDialog("Enter Id:");
        return readNumber(input);
    }

    public String readText(String t) {

        boolean loop = true;

        while (loop) {
            try {

                return t;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Try again");
            }

        }
        return null;
    }

    public static int readNumber(String s) {
        boolean loop = true;
        int id = 0;
        while (loop) {
            try {

                id = Integer.parseInt(s);

                return id;
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Only digits are allowed!!");
                mainMenu();
            }

        }
        return id;
    }

    public <T> void showAll(List<T> list) {
        String printList = "";
        s[0] = "\n**************************LIST OF INFORAMTION******************************************************";
        printList = list.stream().map((elements) -> elements + "\n").reduce(printList, String::concat);
        s[1] = "********************************************************************************************************";
        printList = s[0] + "\n" + printList + "\n" + s[1];
        JOptionPane.showMessageDialog(null, printList);

    }

    public void mainOrExit() {
        s[0] = "Back to main menu, enter 'y'";
        s[1] = "Exit the program, enter 'n'";

        input = JOptionPane.showInputDialog(s[0] + "\n" + s[1]);

        String value = input.toLowerCase();
        if (value.equalsIgnoreCase("Y")) {
            SW.SwitchMainMenu(mainMenu());
        } else if (value.equalsIgnoreCase("N")) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Try again");
            mainOrExit();
        }
    }

}
