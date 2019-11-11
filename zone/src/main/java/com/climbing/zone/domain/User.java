package com.climbing.zone.domain;
//

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

///**
// * A user.
// */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
//
//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;
    private Date modifiedAt;

    @NotNull
//    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 4, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String username;

    //@JsonIgnore
    @NotNull
    @Size(min = 5, max = 20)
    @Column(name = "password_hash", length = 20, nullable = false)
    private String password;

    private boolean blocked;
    private Boolean active;

    private String roles;
    private String authorities;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @Size(min = 3, max = 10)
    @Column(name = "lang_key", length = 10)
    private String langKey;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    public List<String> getRolesList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        } else {
            return new ArrayList<>();
        }
    }

    public List<String> getAuthoritiesList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        } else {
            return new ArrayList<>();
        }
    }


//
//    @Size(max = 20)
//    @Column(name = "activation_key", length = 20)
//    @JsonIgnore
//    private String activationKey;
//
//    @Size(max = 20)
//    @Column(name = "reset_key", length = 20)
//    @JsonIgnore
//    private String resetKey;
//
//    @Column(name = "reset_date")
//    private Instant resetDate = null;
//
//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "authority",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
//
//    @BatchSize(size = 20)
//    private Set<Authority> authorities = new HashSet<>();
//
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
//    private Set<PersistentToken> persistentTokens = new HashSet<>();
//


}