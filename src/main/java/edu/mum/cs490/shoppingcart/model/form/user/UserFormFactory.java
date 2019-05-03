package edu.mum.cs490.shoppingcart.model.form.user;

import edu.mum.cs490.shoppingcart.domain.Customer;
import edu.mum.cs490.shoppingcart.domain.User;
import edu.mum.cs490.shoppingcart.domain.Vendor;

/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
public class UserFormFactory {

    public UserForm getForm(User user) {
        if (user instanceof Vendor) {
            return new VendorForm((Vendor) user);
        } else if (user instanceof Customer) {
            return new CustomerForm((Customer) user);
        } else
            return null;
    }

    public UserForm getEditForm(User user) {
        if (user instanceof Vendor) {
            return new VendorForm((Vendor) user);
        } else if (user instanceof Customer) {
            return new CustomerForm((Customer) user);
        } else
            return null;
    }

}
