package forms;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lubuntu on 10/22/16.
 */
public class SignupForm {
    @Constraints.Required
    public String firstName;
    public String lastName;
    @Constraints.Required
    public String email;
    @Constraints.Required
    public String password;
    public List<ValidationError> validate(){
        List<ValidationError>errors=new ArrayList<>();
        User user=User.find.where().eq("email",email).findUnique();
        if(user!=null){
            errors.add(new ValidationError("message","Incorrect email"));
        }


        return errors;}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
