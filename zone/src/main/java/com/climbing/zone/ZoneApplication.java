package com.climbing.zone;

import com.climbing.zone.domain.*;
import com.climbing.zone.enumeration.BonusType;
import com.climbing.zone.enumeration.FirstName;
import com.climbing.zone.enumeration.Language;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberRepository;
import com.climbing.zone.repository.ClimbingrouteRepository;
import com.climbing.zone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

import java.util.*;

// modification pour le docker de public class ZoneApplication extends SpringBootServletInitializer

@EnableSwagger2
@SpringBootApplication
public class ZoneApplication {

    class RandomEnum<E> {
        Random random = new Random();
        E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[random.nextInt(values.length)];
        }
    }

    @Autowired
    private ClimbingrouteRepository climbingrouteRepository;
    @Autowired
    private ClimberRepository climberRepository;
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    public static final String CONSONANT = "bcdfghklmnpqrstvwxz"; //20
    public static final String CONSONANT1 = "bcd fg hklm npqr stvw x z"; //24
    public static final String VOWEL = "aeiouy"; //6

    //	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(ZoneApplication.class);
//	}
    public static void main(String[] args) {
        SpringApplication.run(ZoneApplication.class, args);
    }

    private PasswordEncoder passwordEncoder;

    public ZoneApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public int fill(int number) {
        return (int) (Math.random() * number);
    }

    public long fillLong(int number) {
        return (long) (Math.random() * number);
    }

    public float getInRange(int min , int max) {

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }



    public String getName(int number) {
        String returnC = "";
        for (int i = 0; i < number; i++) {
            returnC += CONSONANT.charAt(fill(19));
            returnC += VOWEL.charAt(fill(5));
        }
        return returnC;
    }

    public String getText(int number) {
        String returnC = "";
        for (int i = 0; i < number; i++) {
            returnC += CONSONANT1.charAt(fill(24));
            returnC += VOWEL.charAt(fill(5));
        }
        return returnC;
    }

    public void in(String imagePath) {

        InsertImageTest insertImageTest = null;
        insertImageTest.insertImage();
    }

    @PostConstruct
    public void init() {
        RandomEnum bonus = new RandomEnum<BonusType>(BonusType.class);
        RandomEnum language = new RandomEnum<Language>(Language.class);
        RandomEnum routeType = new RandomEnum<RouteType>(RouteType.class);
        RandomEnum zoneType = new RandomEnum<ZoneType>(ZoneType.class);
        RandomEnum firstName = new RandomEnum<FirstName>(FirstName.class);

        Set<Climbingroute> climbingroutes = new HashSet<>();
        Date date = new Date(System.currentTimeMillis());

        for (int i = 0; i < 80; i++) {
//--------------------------------CLIMBER-----------------------------
            Climber climber = new Climber();
            climber.setLastName("" + firstName.random());
            climber.setFirstName("" + firstName.random());
            date = new Date(System.currentTimeMillis());
            climber.setBirth(date);
            climber.setCreatedAt(date);
            climber.setLanguage((Language) language.random());
            climberRepository.save(climber);

//-----------------------------------CLIMBING ROUTE-----------------------------------

            Climbingroute climbingroute = new Climbingroute();
            climbingroute.setClimbingRouteName(getText(20));
            climbingroute.setCreatedAt(date);
            climbingroutes.add(climbingroute);
            climbingroute.setLatitude(getInRange(42, 50));
            climbingroute.setLongitude(getInRange(-5,8));
            climbingroute.setRouteType((RouteType) routeType.random());
            climbingroute.setZoneType((ZoneType) zoneType.random());
            climbingroute.setBonus((BonusType) bonus.random());
            climbingroute.setCreatedAt(date);
            climbingroute.setDifficulty(fill(40));
            climbingroute.setInfo(getText(50));
            climbingroute.setTactical(fill(6));
            climbingroute.setTechnical(fill(6));
            climbingroute.setPhysical(fill(6));
            climbingroute.setMental(fill(6));
            climbingroute.setStar(fill(6));

            climbingrouteRepository.save(climbingroute);
//-----------------------------------CARD-----------------------------------
            for (int j = 0; j < 30; j++) {
                Card card = new Card();
                CardPk cardPk = new CardPk();
                cardPk.setClimber(climber);
                cardPk.setClimbingroute(climbingroute);
                card.setId(cardPk);
                card.setBonus((BonusType) bonus.random());
                card.setDate(date);
                card.setDifficuty("" + fill(40));
                card.setInfo(getText(50));
                card.setTactical(fill(6));
                card.setTechnical(fill(6));
                card.setPhysical(fill(6));
                card.setMental(fill(6));
                card.setQrcode("qrcode_" + fill(1000) + ".jpg");
                card.setPhoto("photo_" + fill(1000) + ".jpg");
                card.setClimbingRouteName(getText(20));
                cardRepository.save(card);
            }
        }
        //-----------------------------------USER-----------------------------------
        //delete all user
        userRepository.deleteAll();


        String email = "" + getName(6) + "@" + "gmail.com";
        String userName = "admin";
        String password =  passwordEncoder.encode("admin");
        String roles = "ADMIN";
        String permissions = "ACCES_ADMIN";
        User admin = new User(userName, password, roles, permissions);
        admin.setEmail("" + getName(6) + "@" + "gmail.com");
        admin.setCreatedAt(new Date(System.currentTimeMillis()));
        userRepository.save(admin);


        userName = "francois";
        password =  passwordEncoder.encode("francois");
        roles = "ADMIN";
        permissions = "ACCES_ADMIN, ACCES_MANAGER";
        User admin1 = new User(userName, password, roles, permissions);
        admin1.setEmail("froxworld@gmail.com");
        admin1.setCreatedAt(new Date(System.currentTimeMillis()));
        userRepository.save(admin1);

        email = "" + getName(6) + "@" + "gmail.com";
        userName = "luc";
        password =  passwordEncoder.encode("luc");
        roles = "MANAGER";
        permissions = "ACCES_MANAGER";
        User luc = new User(userName, password, roles, permissions);
        luc.setEmail(email);
        luc.setCreatedAt(new Date(System.currentTimeMillis()));
        userRepository.save(luc);

        for (int k = 0; k < 10; k++) {
            email = "" + getName(6) + "@" + "gmail.com";
            userName = (getName((10)) + fill(4));
            password =  passwordEncoder.encode(getName(8));
            roles = "USER";
            permissions = "";
            User user1 = new User(userName, password, roles, permissions);
            user1.setCreatedAt(new Date(System.currentTimeMillis()));
            user1.setEmail(email);
            userRepository.save(user1);
        }
    }
}
