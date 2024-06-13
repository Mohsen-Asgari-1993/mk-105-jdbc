package ir.maktabsharif105.jdbc.domain;

import ir.maktabsharif105.jdbc.domain.enumeration.Grade;

public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "users";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String AGE = "age";
    public static final String GENDER = "gender";
    public static final String GRADE = "grade";

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String grade;

    private Grade gradeEnum;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + getId() +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", age=" + age +
               ", gender='" + gender + '\'' +
               ", grade='" + grade + '\'' +
               '}';
    }
}
