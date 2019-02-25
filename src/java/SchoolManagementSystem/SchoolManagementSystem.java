package schoolmanagementsystem;

import SwitchSchool.SwitchSchool;

import static UI.UI.mainMenu;

/*Author:     Ghulam Murtaza
    
               
*/

public class SchoolManagementSystem {

    public static void main(String[] args) {
        SwitchSchool sw = new SwitchSchool();

        sw.SwitchMainMenu(mainMenu());

    }

}
