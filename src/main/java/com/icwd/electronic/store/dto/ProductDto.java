package com.icwd.electronic.store.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {


    private String productId;

    private String title;

    private String description;

    private Double price;

    private Long quantity;

    private Date addeddate;
    @NonNull
    private Boolean live;

    private Boolean stock;

    private Double descountprice;

    private String productimagename;
}
