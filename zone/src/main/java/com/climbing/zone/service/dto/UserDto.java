package com.climbing.zone.service.dto;

import com.climbing.zone.domain.User;
import com.climbing.zone.enumeration.Language;
import lombok.*;

import java.io.Serializable;
import java.util.*;

////import com.climbing.zone.config.Constants;
//import com.climbing.zone.domain.User;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//
//import javax.validation.constraints.*;
//import java.time.Instant;
//import java.util.Set;
//import java.util.stream.Collectors;


@NoArgsConstructor //génère le constructeur sans argument et public ;
@AllArgsConstructor //génère le constructeur avec tous les arguments
@Getter //génère tous les getters sur les champs ;
@Setter //génère tous les setters sur les champs ;
@EqualsAndHashCode(of = {"id", "username"})
// génère equals et hashCode (et d'autres méthodes) sur les champs donnés ;
@ToString(of = {"id", "username", "language"}) //To String
public class UserDto  implements Serializable  {


    private Long id;
    private String username;
    private String email;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private Language language;

        public UserDto(User user) {
            toDto(user);
        }

        private Long sessionId;

        public static List<UserDto> toDTO(Iterable<User> all) {
            List<UserDto> userDtoList = new ArrayList<>();
            for (User user : all) {
                userDtoList.add(new UserDto(user));
            }
            return userDtoList;
        }

        public void toDto(User user) {
            Date date = new Date(System.currentTimeMillis());
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.createdAt = user.getCreatedAt();
            this.modifiedAt = date;
        }


        public User fromDTO(UserDto userDto){
            Date date = new Date(System.currentTimeMillis());
            User user = new User();
            user.setUsername( userDto.getUsername());
            user.setEmail(user.getEmail());
            user.setCreatedAt(userDto.getCreatedAt());
            user.setModifiedAt(date);

            return user;
        }
}

//
//    public UserDto(User user) {
//        this.id = user.getId();
//        this.login = user.getLogin();
//        this.firstName = user.getFirstName();
//        this.lastName = user.getLastName();
//        this.email = user.getEmail();
//        this.activated = user.getActivated();
//        this.imageUrl = user.getImageUrl();
//        this.langKey = user.getLangKey();
//        this.createdBy = user.getCreatedBy();
//        this.createdDate = user.getCreatedDate();
//        this.lastModifiedBy = user.getLastModifiedBy();
//        this.lastModifiedDate = user.getLastModifiedDate();
//        this.authorities = user.getAuthorities().stream()
//                .map(Authority::getName)
//                .collect(Collectors.toSet());
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public boolean isActivated() {
//        return activated;
//    }
//
//    public void setActivated(boolean activated) {
//        this.activated = activated;
//    }
//
//    public String getLangKey() {
//        return langKey;
//    }
//
//    public void setLangKey(String langKey) {
//        this.langKey = langKey;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Instant getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Instant createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public String getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//
//    public void setLastModifiedBy(String lastModifiedBy) {
//        this.lastModifiedBy = lastModifiedBy;
//    }
//
//    public Instant getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Instant lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public Set<String> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(Set<String> authorities) {
//        this.authorities = authorities;
//    }
//
//    @Override
//    public String toString() {
//        return "UserDTO{" +
//                "login='" + login + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", imageUrl='" + imageUrl + '\'' +
//                ", activated=" + activated +
//                ", langKey='" + langKey + '\'' +
//                ", createdBy=" + createdBy +
//                ", createdDate=" + createdDate +
//                ", lastModifiedBy='" + lastModifiedBy + '\'' +
//                ", lastModifiedDate=" + lastModifiedDate +
//                ", authorities=" + authorities +
//                "}";
//    }
//}