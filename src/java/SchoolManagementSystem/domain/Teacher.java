package schoolmanagementsystem.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/*Authors:     Ghulam Murtaza
     **        
               
 */
@NamedQueries({
    @NamedQuery(name = "showByTName", query = ("Select a From Teacher a Where a.name Like :name"))
    ,
        @NamedQuery(name = "showAllT", query = ("Select a From Teacher a")),})

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @Basic
    private String gender;

    @Basic
    private int age;

    @ManyToMany(mappedBy = "teachers")
    private List<Courses> courses;

    public Teacher() {
    }

    public Teacher(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Courses> getCourses() {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        return this.courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public void addCourse(Courses course) {
        getCourses().add(course);
    }

    public void removeCourse(Courses course) {
        getCourses().remove(course);
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age;
    }

}
