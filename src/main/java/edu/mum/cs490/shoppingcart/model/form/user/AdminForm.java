package edu.mum.cs490.shoppingcart.model.form.user;

import edu.mum.cs490.shoppingcart.domain.Admin;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
public class AdminForm extends UserForm implements Serializable {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    public AdminForm() {
    }

    public AdminForm(Admin admin) {
        super(admin);
        this.firstName = admin.getFirstName();
        this.lastName = admin.getLastName();
    }

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
}
