package com.scm.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User
{

    @Id
    private String id;

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @Lob
    @Size(max = 5000, message = "About section must not exceed 5000 characters")
    private String about;

    @Column(length = 1000)
    @Size(max = 1000, message = "Profile picture URL must not exceed 1000 characters")
    private String profilePicture;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must be 10 digits"
    )
    private String phoneNumber;

    @NotNull(message = "Enabled flag cannot be null")
    private Boolean enabled = false;

    @NotNull(message = "Email verified flag cannot be null")
    private Boolean emailVerified = false;

    @NotNull(message = "Phone verified flag cannot be null")
    private Boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    // SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
    private Providers provider = Providers.SELF;
    private String emailToken;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Contact> contacts = new LinkedHashSet<>();

}
