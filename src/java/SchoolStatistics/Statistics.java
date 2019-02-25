package SchoolStatistics;

import java.util.List;

import javax.persistence.*;
import javax.swing.JOptionPane;
import schoolmanagementsystem.domain.*;

/*Authors:     Ghulam Murtaza
     
               
 */
public class Statistics {

    static String[] print = new String[5];

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void totalStudent() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id) From Student a", Student.class);
        int n = ((Number) query.getSingleResult()).intValue();
        print[0] = "******************************************";
        print[1] = "THE TOTAL NO. OF STUDENTS ARE: " + n;
        print[2] = "*******************************************";
        JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
    }

    public static void totalTeachers() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id)From Teacher a", Teacher.class);
        List<Teacher> list = query.getResultList();
        print[0] = "********************************************";
        print[1] = "THE TOTAL NO. OF TEACHERS ARE: " + list;
        print[2] = "********************************************";
        JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
    }

    public static void totalCourses() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id)From Courses a", Courses.class);
        List<Courses> list = query.getResultList();
        print[0] = "********************************************";
        print[1] = "THE TOTAL NO. OF COURSES ARE: " + list;
        print[2] = "********************************************";
        JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
    }

    public static void totalEducations() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id)From Education a", Education.class);
        int n = ((Number) query.getSingleResult()).intValue();
        print[0] = "********************************************";
        print[1] = "THE TOTAL NO. OF EDUCATIONS ARE: " + n;
        print[2] = "********************************************";
        JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
    }

    public static void numberOfMale() {

        switch (input()) {
            case 1: {
                EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("Select Count(a.gender) From Student a Where a.gender Like 'm%'", Student.class);
                List<Student> list = query.getResultList();
                print[0] = "********************************************";
                print[1] = "THE TOTAL NO. OF MALE STUDENTS ARE: " + list;
                print[2] = "********************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }
            case 2: {
                EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("Select Count(a.gender) From Teacher a Where a.gender Like 'm%'", Teacher.class);
                List<Teacher> list = query.getResultList();
                print[0] = "********************************************";
                print[1] = "THE TOTAL NO. OF MALE TEACHERS ARE: " + list;
                print[2] = "********************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }
            default:
                numberOfMale();
                break;
        }

    }

    public static void numberOfFemale() {
        switch (input()) {
            case 1: {
                EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("Select Count(a.gender) From Student a Where a.gender like 'f%'", Student.class);
                List<Student> list = query.getResultList();
                print[0] = "***************************************************";
                print[1] = "THE TOTAL NO. FEMALE STUDENTS ARE: " + list;
                print[2] = "***************************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }
            case 2: {
                EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("Select Count(a.gender)From Teacher a Where a.gender like 'f%'", Teacher.class);
                List<Teacher> list = query.getResultList();
                print[0] = "***************************************************";
                print[1] = "THE TOTAL NO. OF FEMALE TEACHERS ARE: " + list;
                print[2] = "***************************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }

        }
    }

    public static void avarageAge() {
        EntityManager em = emf.createEntityManager();
        switch (input()) {

            case 1: {
                Query query = em.createQuery("Select AVG(a.age)From Student a", Student.class);
                List<Student> list = query.getResultList();
                print[0] = "***************************************************";
                print[1] = "THE AVARAGE AGE OF THE STUDENTS ARE: " + list;
                print[2] = "***************************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }
            case 2: {
                Query query = em.createQuery("Select AVG(a.age)From Teacher a", Teacher.class);
                List<Teacher> list = query.getResultList();
                print[0] = "***************************************************";
                print[1] = "THE AVARAGE AGE OF THE TEACHERS ARE: " + list;
                print[2] = "***************************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }
            default:
                System.out.println("Try again");
                avarageAge();
                break;

        }
    }

    public static void highestAge() {
        EntityManager em = emf.createEntityManager();
        switch (input()) {
            case 1: {
                Query query = em.createQuery("Select MAX(a.age)From Student a", Student.class);
                List<Student> list = query.getResultList();
                print[0] = "***************************************************";
                print[1] = "THE HIGHEST AGE OF THE STUDENTS IS: " + list;
                print[2] = "***************************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }
            case 2: {
                Query query = em.createQuery("Select MAX(a.age)From Teacher a", Teacher.class);
                List<Teacher> list = query.getResultList();
                print[0] = "***************************************************";
                print[1] = "THE HIGHEST AGE OF THE TEACHERS IS: " + list;
                print[2] = "***************************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");

                break;
            }
            default:
                highestAge();
                break;
        }
    }

    public static void lowestAge() {
        EntityManager em = emf.createEntityManager();
        switch (input()) {
            case 1: {
                Query query = em.createQuery("Select MIN(a.age)From Student a", Student.class);
                List<Student> list = query.getResultList();
                print[0] = "***************************************************";
                print[1] = "THE LOWEST AGE OF THE STUDENTS IS:" + list;
                print[2] = "***************************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }
            case 2: {
                Query query = em.createQuery("Select MIN(a.age) From Teacher a", Teacher.class);
                List<Teacher> list = query.getResultList();
                print[0] = "***************************************************";
                print[1] = "THE LOWEST AGE OF THE TEACHERS IS: " + list;
                print[2] = "***************************************************";
                JOptionPane.showMessageDialog(null, print[0] + "\n" + print[1] + "\n" + print[2] + "\n");
                break;
            }
            default:
                JOptionPane.showMessageDialog(null, "Try again");
                lowestAge();
        }
    }

    public static int input() {
        int val = 0;
        try {
            print[0] = "*****************";
            print[1] = "1.Students";
            print[2] = "2.Teachers";
            print[3] = "*****************";
            String input = JOptionPane.showInputDialog(print[0] + "\n" + print[1] + "\n" + print[2] + "\n" + print[3] + "\n");
            val = Integer.parseInt(input);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Choose between 1 and 2");

        }
        return val;
    }
}
