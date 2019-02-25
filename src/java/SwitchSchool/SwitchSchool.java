package SwitchSchool;

import UI.UI;
import DAO.SchoolDaoImp;
import SchoolStatistics.Statistics;
import static UI.UI.mainMenu;
import javax.swing.JOptionPane;

/*Author:     Ghulam Murtaza
    
               
 */
public class SwitchSchool {

    String input, s = null;
    int result;

    SchoolDaoImp sdao = new SchoolDaoImp();
    UI user = new UI();

    public void SwitchMainMenu(int val) {
        boolean loop = true;
        while (loop) {
            switch (val) {

                case 0:
                    System.exit(0);
                    break;
                case 1:
                    user.managementMenu();
                    break;
                case 2:
                    user.SchoolStatistics();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Try again");
                    mainMenu();
                    break;
            }
            loop = false;
        }
    }

    public void SwitchManagement(int val) {
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    user.regMenu();
                    break;
                case 2:
                    user.findMenu();
                    break;
                case 3:
                    user.updateMenu();
                    break;
                case 4:
                    user.removeMenu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Wrong Choice");
                    user.managementMenu();
                    break;
            }
            loop = false;
        }
    }

    public void SwitchFind(int val) {

        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:

                    user.managementMenu();
                    break;
                case 1:
                    user.showAll(sdao.showAll("Students"));
                    break;
                case 2:

                    input = JOptionPane.showInputDialog("Which student are you looking for?");

                    sdao.findStudentById(UI.readNumber(input));
                    break;
                case 3:
                    user.showAll(sdao.findStudentByName(user.enterName()));
                    break;
                case 4:
                    s = "**************************All COURSES*******************************";

                    input = JOptionPane.showInputDialog(s + "\n" + sdao.showCourseInfo() + "\n\n ENTER THE COURSE ID TO SEE ALL THE STUDENTS IN THE COURSE...");
                    sdao.findStudentsByCourse(UI.readNumber(input));
                    break;
                case 5:
                    s = ("**************************All Education*******************************");

                    input = JOptionPane.showInputDialog(s + "\n" + sdao.showEducationinfo() + "\n\n ENTER THE EDUCATION ID TO SEE ALL THE STUDENTS IN THE EDUCATION...");
                    user.showAll(sdao.findStudentsByEducation(UI.readNumber(input)));
                    break;
                case 6:

                    sdao.showTeacherInfo();
                    user.showAll(sdao.showAll("Teachers"));
                    break;
                case 7:

                    input = JOptionPane.showInputDialog("\n\n Which teacher are you looking for?");
                    sdao.findTeacherById(UI.readNumber(input));
                    break;
                case 8:
                    user.showAll(sdao.findTeacherByName(user.enterName()));
                    break;
                case 9:
                    s = "********************************ALL COURSES****************************************";

                    input = JOptionPane.showInputDialog(s + "\n" + sdao.showCourseInfo() + "\n\n ENTER THE COURSE ID TO SEE ALL TEACHERS IN THE COURSE...");
                    user.showAll(sdao.findTeacherByCourse(UI.readNumber(input)));
                    break;
                case 10:
                    s = "****************************************ALL EDUCATIONS***********************************************";
                    input = JOptionPane.showInputDialog(s + "\n" + sdao.showEducationinfo() + "\n\n ENTER THE EDUCATION ID TO SEE ALL THE TEACHERS IN THE EDUCATION...");
                    sdao.findTeacherByEducation(UI.readNumber(input));

                    break;
                case 11:
                    user.showAll(sdao.showAll("Courses"));
                    break;
                case 12:
                    user.showAll(sdao.showAll("Education"));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Wrong Choice");
                    JOptionPane.showInputDialog(null, user.managementMenu());
                    break;
            }
            loop = false;
        }
        user.findMenu();
    }

    public void SwitchRegister(int val) {

        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    user.managementMenu();
                    break;
                case 1:

                    sdao.registerStudentToEducation(user.enterName(), user.enterGender(), user.enterAge());
                    break;
                case 2:

                    sdao.registerTeacherToCourse(user.enterName(), user.enterAge(), user.enterGender());
                    break;
                case 3:

                    sdao.addExistingTeacherToCourse();
                    break;
                case 4:
                    sdao.registerEducation(user.enterName());
                    break;
                case 5:
                    sdao.registerCourseToEducation(user.enterName());
                    break;
                case 6:

                    sdao.courseEducation();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Wrong Choice");
                    JOptionPane.showInputDialog(null, user.regMenu());

                    break;
            }
            loop = false;
        }
        user.regMenu();
    }

    public void SwitchUpdate(int val) {

        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    user.managementMenu();
                    break;
                case 1:

                    sdao.showStudentInfo();
                    sdao.updateStudentsName(user.enterId(), user.enterName());
                    break;
                case 2:

                    sdao.showTeacherInfo();
                    sdao.updateTeachersName(user.enterId(), user.enterName());
                    break;
                case 3:

                    sdao.studentEducation();
                    break;
                case 4:

                    sdao.updateRemoveTeacherCourse();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Wrong Choice");
                    user.updateMenu();
                    break;
            }
            loop = false;
        }
        user.updateMenu();
    }

    public void SwitchRemove(int val) {

        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    user.managementMenu();
                    break;
                case 1:
                    sdao.removeStudent(user.enterId());
                    break;
                case 2:
                    sdao.removeTeacher(user.enterId());
                    break;
                case 3:
                    sdao.removeCourse();
                    break;
                case 4:
                    sdao.removeEducation();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Wrong Choice");
                    user.removeMenu();
                    break;
            }
            loop = false;
        }
        user.removeMenu();
    }

    public void SwitchStats(int val) {
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    UI.mainMenu();
                    break;
                case 1:
                    Statistics.totalStudent();

                    break;
                case 2:
                    Statistics.totalTeachers();
                    break;
                case 3:
                    Statistics.totalCourses();
                    break;
                case 4:
                    Statistics.totalEducations();
                    break;
                case 5:
                    Statistics.numberOfMale();
                    break;
                case 6:
                    Statistics.numberOfFemale();
                    break;
                case 7:
                    Statistics.avarageAge();
                    break;
                case 8:
                    Statistics.highestAge();
                    break;
                case 9:
                    Statistics.lowestAge();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Try again......");
                    user.SchoolStatistics();
                    break;
            }
            loop = false;
        }

        user.SchoolStatistics();

    }
}
