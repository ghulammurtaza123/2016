package DAO;

import UI.UI;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;
import schoolmanagementsystem.domain.Courses;

import schoolmanagementsystem.domain.Education;
import schoolmanagementsystem.domain.Student;
import schoolmanagementsystem.domain.Teacher;

/*Author:     Ghulam Murtaza
    
               
*/
public class SchoolDaoImp implements SchoolManagementDAO {        //Class to implement School DAO methods

    String s1, s2, print;
    int id, x, y, results;
    int[] transfer = new int[2];                //used to transfer text input from text fields

    JTextField xField = new JTextField(5);
    JTextField yField = new JTextField(5);
    UI user = new UI();
    Education education = new Education();
    Teacher teacher = new Teacher();
    Student student = new Student();
    Courses course = new Courses();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Override
    public void registerStudentToEducation(String name, String gender, int age) {
        s1 = JOptionPane.showInputDialog(showEducationinfo() + "\n Enter education id for New Student:  ");
        id = Integer.parseInt(s1);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student studentC = new Student(name, age, gender);
        em.persist(studentC);
        Education edu = em.find(Education.class, id);
        edu.addStudent(studentC);
        em.persist(edu);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void registerTeacherToCourse(String name, int age, String gender) {
        s1 = JOptionPane.showInputDialog(showCourseInfo() + "\n Enter Course id for New Teacher: ");
        id = Integer.parseInt(s1);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        teacher = new Teacher(name, age, gender);
        em.persist(teacher);
        course = em.find(Courses.class, id);
        course.addTeacher(teacher);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void registerEducation(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        education = new Education(name);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void registerCourseToEducation(String name) {
        s1 = JOptionPane.showInputDialog(showEducationinfo() + "\n Enter education id for the course: ");
        id = Integer.parseInt(s1);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        course = new Courses(name);
        education = em.find(Education.class, id);
        education.addCourse(course);
        em.persist(course);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void addExistingCourseToEducation(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        course = em.find(Courses.class, id);
        education = em.find(Education.class, id2);

        education.addCourse(course);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void addExistingTeacherToCourse() {
        transfer = teacherCourse();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        teacher = em.find(Teacher.class, transfer[0]);
        course = em.find(Courses.class, transfer[1]);

        course.addTeacher(teacher);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void findStudentById(int id) {
        try {
            EntityManager em = emf.createEntityManager();
            student = em.find(Student.class, id);
            JOptionPane.showMessageDialog(null, student);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO STUDENT WITH THAT ID FOUND");
        }

    }

    @Override
    public List<Student> findStudentByName(String name) {

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("showByName", Student.class);
        query.setParameter("name", "%" + name + "%");
        List<Student> list = query.getResultList();

        em.close();
        return list;
    }

    @Override
    public List<Student> findStudentsByCourse(int id) {

        List<String> name = new ArrayList<>();

        EntityManager em = emf.createEntityManager();

        course = em.find(Courses.class, id);

        List<Education> educations = course.getEducations();

        List<Student> students = new ArrayList<>();
        educations.forEach((education1) -> {
            students.addAll(education1.getStudents());

        });

        students.forEach((studentList) -> {
            if (!name.contains(studentList.getName())) {
                name.add(studentList.getName());
            }

        });

        JOptionPane.showMessageDialog(null, name);
        return students;
    }

    @Override
    public List<Student> findStudentsByEducation(int id) {
        EntityManager em = emf.createEntityManager();
        education = em.find(Education.class, id);
        List<Student> list = education.getStudents();

        return list;
    }

    @Override
    public void findTeacherById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        teacher = em.find(Teacher.class, id);
        JOptionPane.showMessageDialog(null, teacher);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Teacher> findTeacherByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("showByTName", Teacher.class);
        query.setParameter("name", "%" + name + "%");
        List<Teacher> list = query.getResultList();
        em.close();
        return list;

    }

    @Override
    public List<Teacher> findTeacherByCourse(int id) {
        EntityManager em = emf.createEntityManager();
        course = em.find(Courses.class, id);
        List<Teacher> list = course.getTeachers();
        return list;
    }

    @Override
    public List<Teacher> findTeacherByEducation(int id) {
        print = "";
        List<String> name = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        education = em.find(Education.class, id);

        List<Courses> courses = education.getCourses();

        List<Teacher> teachers = new ArrayList<>();
        courses.forEach((course1) -> {
            teachers.addAll(course1.getTeachers());
        });

        teachers.forEach((teacherN) -> {
            if (!name.contains(teacherN.getName())) {
                name.add(teacherN.getName());
                print += name + "\n";
            }

        });
        JOptionPane.showMessageDialog(null, name);
        return teachers;
    }

    @Override
    public <T> List<T> showAll(String t) {

        EntityManager em = emf.createEntityManager();
        List<T> list;
        if (t.equalsIgnoreCase("teachers")) {
            list = (List<T>) em.createNamedQuery("showAllT", Teacher.class).getResultList();

            return list;
        } else if (t.equalsIgnoreCase("students")) {
            list = (List<T>) em.createNamedQuery("showAll", Student.class).getResultList();
            return list;
        } else if (t.equalsIgnoreCase("courses")) {
            list = (List<T>) em.createNamedQuery("showAllC", Courses.class).getResultList();
            return list;
        } else if (t.equalsIgnoreCase("education")) {
            list = (List<T>) em.createNamedQuery("showAllE", Education.class).getResultList();
            return list;
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void showStudentInfo() {
        print = "";
        List<Student> list = showAll("student");
        list.forEach((students) -> {
            print += "ID: " + students.getId() + " " + students.getName() + "\n";
        });
    }

    @Override
    public String showTeacherInfo() {
        print = "";
        List<Teacher> list = showAll("teachers");
        list.forEach((teachers) -> {
            print += "ID: " + teachers.getId() + " " + teachers.getName() + "\n";
        });
        return print;
    }

    @Override
    public String showEducationinfo() {
        print = "";
        List<Education> list = showAll("education");
        list.forEach((educations) -> {
            print += "ID:" + educations.getId() + " " + educations.getName() + "\n";
        });
        return print;
    }

    @Override
    public String showCourseInfo() {
        print = "";
        List<Courses> list = showAll("courses");
        list.forEach((courses) -> {
            print += "ID:" + courses.getId() + " " + courses.getName() + "\n";
        });
        return print;
    }

    @Override
    public boolean updateStudentEducation(int id, int id2) {
        try {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            student = em.find(Student.class, id);
            education = em.find(Education.class, id2);
            student.setEducation(education);
            em.persist(student);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "<<Try again>>NO SUCH STUDENT OR EDUCATION FOUND<<Try again>>");
            JOptionPane.showMessageDialog(null, user.updateMenu());
        }
        return true;
    }

    @Override
    public boolean updateRemoveTeacherCourse() {
        try {
            transfer = teacherCourse();

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            teacher = em.find(Teacher.class, transfer[0]);
            course = em.find(Courses.class, transfer[1]);

            course.removeTeacher(teacher);
            em.persist(course);

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "<<Try again>>NO SUCH TEACHER OR COURSE FOUND<<Try again>>");
            JOptionPane.showMessageDialog(null, user.updateMenu());
        }
        return true;
    }

    @Override
    public boolean updateStudentsName(int id, String name) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            student = em.find(Student.class, id);
            student.setName(name);
            em.persist(student);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "<<Try again>>NO STUDENT FOUND<<Try again>>");
            JOptionPane.showMessageDialog(null, user.updateMenu());
        }
        return true;
    }

    @Override
    public boolean updateTeachersName(int id, String name) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            teacher = em.find(Teacher.class, id);
            teacher.setName(name);
            em.persist(teacher);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "<<Try again>>NO TEACHER FOUND<<Try again>>");
            JOptionPane.showMessageDialog(null, user.updateMenu());
        }
        return true;

    }

    @Override
    public boolean removeStudent(int id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            student = em.find(Student.class, id);

            em.remove(student);
            education.removeStudent(student);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "<<Try again>>No Student Found<<Try again>>");
            return false;
        }
        return true;
    }

    @Override
    public boolean removeTeacher(int id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            teacher = em.find(Teacher.class, id);

            em.remove(teacher);
            course.removeTeacher(teacher);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "<<Try again>>No Teacher Found<<Try again>>");
            return false;
        }
        return true;
    }

    @Override
    public boolean removeCourse() {
        try {
            s1 = JOptionPane.showInputDialog(showCourseInfo() + "\n Enter course id to remove: ");
            id = Integer.parseInt(s1);
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            course = em.find(Courses.class, id);
            em.remove(course);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "<<Try again>>No Course Found<<Try again>>");
            return false;
        }

        return true;

    }

    @Override
    public boolean removeEducation() {
        try {
            s1 = JOptionPane.showInputDialog(showEducationinfo() + "\n Enter education id to remove: ");
            id = Integer.parseInt(s1);
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            education = em.find(Education.class, id);

            List<Student> list = education.getStudents();
            list.forEach((students) -> {
                em.remove(students);
            });
            em.remove(education);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "<<Try again>>No Education Found<<Try again>>");
            return false;
        }
        return true;
    }

    public void courseEducation() {
        Object[] message2 = {
            showEducationinfo(),
            "Course ID:", xField,
            "Education ID :", yField,};

        results = JOptionPane.showConfirmDialog(null, message2,
                "Enter the Course ID and the Education ID", JOptionPane.OK_CANCEL_OPTION);
        if (results == JOptionPane.OK_OPTION) {
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
            addExistingCourseToEducation(x, y);
        }

    }

    public void studentEducation() {
        Object[] message2 = {
            showEducationinfo(),
            "STUDENT ID:", xField,
            "Education ID :", yField,};

        results = JOptionPane.showConfirmDialog(null, message2,
                "Enter the Student ID and the Education ID", JOptionPane.OK_CANCEL_OPTION);
        if (results == JOptionPane.OK_OPTION) {
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
            updateStudentEducation(x, y);
        }

    }

    public int[] teacherCourse() {

        Object[] message = {
            showCourseInfo(),
            "Teacher ID:", xField,
            "Course ID :", yField,};

        results = JOptionPane.showConfirmDialog(null, message,
                "Enter the Teacher ID and the Course ID", JOptionPane.OK_CANCEL_OPTION);
        if (results == JOptionPane.OK_OPTION) {
            transfer[0] = Integer.parseInt(xField.getText());
            transfer[1] = Integer.parseInt(yField.getText());

        }

        return transfer;
    }

}
