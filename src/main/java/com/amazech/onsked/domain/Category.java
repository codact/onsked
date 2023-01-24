package com.amazech.onsked.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Data
public class Category implements Serializable {
    private String categoryCode;
    @NotBlank(message = "Category Name is mandatory")
    private String categoryName;
    private String details;
    private String resourceTitle;
    private String resourceTitlePlural;
    private String receiverTitle;
    private String receiverTitlePlural;
    private String isActive;
}
