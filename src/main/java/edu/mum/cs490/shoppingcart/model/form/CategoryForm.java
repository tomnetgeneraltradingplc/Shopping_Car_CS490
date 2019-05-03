package edu.mum.cs490.shoppingcart.model.form;

import edu.mum.cs490.shoppingcart.domain.Category;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created by Ezequiel Suarez Buitrago, Thomas Tibebu,
 * Innocent Kateba, shuling he, Wenxin He, Tram Ly
 * Date April 20, 2019
 **/
public class CategoryForm implements Serializable {

    private Integer id;
    @NotBlank(message = "Can not be empty")
    private String name;
    private MultipartFile file;
    private Integer parentId;

    public CategoryForm() {
    }

    public CategoryForm(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.parentId = category.getParentCategory() != null ? category.getParentCategory().getId() : null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
