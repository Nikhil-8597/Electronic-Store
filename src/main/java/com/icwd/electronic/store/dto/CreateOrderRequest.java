package com.icwd.electronic.store.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class CreateOrderRequest {

    @NotBlank(message = "Cart id is required")
    private String cartId;
    @NotBlank(message = "user id is required")
    private String id;
    private String orderStatus="PENDING";
    private String paymentStatus="NOTPAID";
    @NotBlank(message = "Address is required")
    private String billingAddress;
    @NotBlank(message = "Phone number is required")
    private String billingPhone;
    @NotBlank(message = "Billing Name is required")
    private String billingName;
}
