package com.openpay.donation.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String name;
    @NotBlank(message = "El apellido del cliente es obligatorio")
    private String lastName;
    @NotBlank(message = "El numero telefonico debe ser obligatorio")
    @Size(min = 10, max = 10, message = "El numero debe ser menor o mayor a 10 digitos")
    private String phoneNumber;
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "No cumple con el formato de email")
    private String email;
    @NotNull(message = "Debe especificar el monto de la donacion")
    @Min(value = 1, message = "El valor minimo permitido es de 1 peso")
    @Max(value = 10000, message = "El valor máximo permitido es de 10,000 pesos")
    private Long amount;
}
