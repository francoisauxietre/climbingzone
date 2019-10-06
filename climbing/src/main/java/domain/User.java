package domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Entity
@JsonIgnoreProperties(value = {"id", "modifyAt", "deleteAt"})
public class User {

    Long Id;
    String name;
    String firstName;
    Date birth;
    List<User> friendsList = new ArrayList<>();

    Date createAt;
    //@JsonIgnore
    Date modifyAt;
    Date deleteAt;



    Logger logger = LoggerFactory.getLogger(User.class);

    public User(){
        java.sql.Date date =  new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println("ici "+ date.toString());
        this.createAt = date;
    };

    public User(String name, String firstName, java.sql.Date birth, List<User> friendsList) {
        this.name =name;
        this.firstName = firstName;
        this.birth = birth;
        this.friendsList = friendsList;
        java.sql.Date date =  new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println("ici "+ date.toString());
        this.createAt = date;

    }

    // a chaque fois qu'on mettra un persist on va faire un log
    @PrePersist
    public void startLog() {
        logger.info("creation de l'utilisateur en cours " + this.name);
    }

    @PostPersist
    public void stopLog() {
        logger.info("creation faite de " + this.name);
    }


    @PreDestroy
    public void destroy() {
        logger.info("destruction de " + this.name);
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @ManyToMany
    @JsonBackReference // pour pas que il y ait un appel d'ami a un ami qui est un ami ....
    @JoinTable(name = "friendsList")
    public List<User> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<User> friendsList) {
        this.friendsList = friendsList;
    }

    public void addFriend(User friend) {
        this.friendsList.add(friend);
    }


    @Basic
    @Temporal(value = TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", nom='" + name + '\'' +
                ", prenom='" + firstName + '\'' +
                ", date_de_naissance=" + birth +
                '}';
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }
}
