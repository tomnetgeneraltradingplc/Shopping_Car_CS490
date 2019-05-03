package edu.mum.cs490.shoppingcart.model.form.user;

import edu.mum.cs490.shoppingcart.domain.Vendor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
public class VendorForm extends UserForm implements Serializable {

    @NotBlank
    private String companyName;

    public VendorForm() {
    }

    public VendorForm(Vendor vendor) {
        super(vendor);
        this.companyName = vendor.getCompanyName();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
