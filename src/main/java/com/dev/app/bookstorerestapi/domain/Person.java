package com.dev.app.bookstorerestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    @NotBlank
    @Size(min = 2, max = 25)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 25)
    private String lastName;

    @NotBlank
    @Email
    private String email;
}
