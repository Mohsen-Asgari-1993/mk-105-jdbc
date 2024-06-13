package ir.maktabsharif105.jdbc.domain;

import ir.maktabsharif105.jdbc.domain.enumeration.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    private Set<Role> roles;

    private Set<String> phoneNumbers;

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
