package dev.jeep.Lookpay.dtos;

import lombok.Data;

@Data
public class ResetPasswordDTO {
    private String email;
    private String name;
    private String dni_ruc;
    private String phoneNumber;
    private String originDate;
    private String type;
}
