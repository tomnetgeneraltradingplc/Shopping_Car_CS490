package edu.mum.cs490.shoppingcart.model.form.user;

import edu.mum.cs490.shoppingcart.domain.Customer;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
public class CustomerForm extends UserForm implements Serializable {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    public CustomerForm() {
    }

    public CustomerForm(Customer customer) {
        super(customer);
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
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
