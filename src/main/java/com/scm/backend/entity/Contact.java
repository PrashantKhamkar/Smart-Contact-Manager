package com.scm.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user_contact")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact
{
    @Id
    private String id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must be exactly 10 digits"
    )
    private String phoneNumber;

    @Size(max = 300, message = "Address must not exceed 300 characters")
    private String address;

    @Size(max = 1000, message = "Picture URL must not exceed 1000 characters")
    private String picture;

    @Lob
    @Size(max = 5000, message = "Description must not exceed 5000 characters")
    private String description;

    private boolean favorite = false;

    @Size(max = 1000, message = "Website link must not exceed 1000 characters")
    private String websiteLink;

    @Size(max = 1000, message = "LinkedIn link must not exceed 1000 characters")
    private String linkedInLink;

    @Size(max = 1000, message = "Instagram link must not exceed 1000 characters")
    private String instagramLink;

    @Size(max = 500, message = "Cloudinary image public ID must not exceed 500 characters")
    private String cloudinaryImagePublicId;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


}
