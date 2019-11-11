package com.climbing.zone.domain;

import com.climbing.zone.enumeration.Language;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A Climber.
 */
@Slf4j
@Entity
@Table(name = "climber")
@Data
public class Climber implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "climber_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth")
    private Date birth;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "modified_at")
    private Date modifiedAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "deleted_at")
    private Date deletedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Language language;

    @OneToMany(mappedBy = "climbers")
    private Set<Country> countries = new HashSet<>();

    @OneToMany(mappedBy = "id.climbingroute")//, cascade = CascadeType.ALL
    @JsonManagedReference
    private Set<Card> cards = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("openers")
    private Climbingroute openBy;

    public void addCard(Card card) {
        cards.add(card);
    }

    @ManyToMany
    @JoinTable(name = "climber_friends",
            joinColumns = @JoinColumn(name = "climber_id", referencedColumnName = "climber_id"),
            inverseJoinColumns = @JoinColumn(name = "friends_id", referencedColumnName = "climber_id"))
    private Set<Climber> friends = new HashSet<>();

    @ManyToMany(mappedBy = "friends")
    @JsonIgnore
    private Set<Climber> fromFriends = new HashSet<>();

    public void addFriends(Climber climber) {
        this.friends.add(climber);
    }

    public void removeFriends(Climber climber) {
        this.friends.forEach(climber1 -> {
            if (climber1.getId() == climber.getId()) {
                friends.remove(climber);
                log.info("climber"+climber.getFirstName()+"was delete form your friends");

            }
        });
    }

}
