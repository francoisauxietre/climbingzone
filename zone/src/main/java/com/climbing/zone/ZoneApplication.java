package com.climbing.zone;

import com.climbing.zone.domain.*;
import com.climbing.zone.enumeration.BonusType;
import com.climbing.zone.enumeration.FirstName;
import com.climbing.zone.enumeration.Language;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberRepository;
import com.climbing.zone.repository.ClimbingrouteRepository;
import com.climbing.zone.repository.UserRepository;
import com.fasterxml.classmate.TypeResolver;
import net.bytebuddy.utility.RandomString;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.*;
import java.lang.Object;

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

    public int fill(int number) {
        return (int) (Math.random() * number);
    }

    public float getLatitude(int number) {
        boolean signe = ((Math.random()) > .5) ? true : false;
        if (signe) {
            return (float) -(Math.random());
        } else {
            return (int) (Math.random() * number);
        }
    }

    public float getLongitude(int number) {
        boolean signe = ((Math.random()) > .5) ? true : false;
        if (signe) {
            return (float) -(Math.random());
        } else {
            return (int) (Math.random() * number);
        }
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

        Set<Climber> climbers = new HashSet<>();
        Set<Climbingroute> climbingroutes = new HashSet<>();

        for (int i = 0; i < 20; i++) {
//--------------------------------CLIMBER-----------------------------
            Climber climber = new Climber();
            climber.setLastName("" + firstName.random());
            climber.setFirstName("" + firstName.random());
//            climber.setId((long) fill(40));
            Date date = new Date(System.currentTimeMillis());
            climber.setBirth(date);
            climber.setCreatedAt(date);
            climber.setLanguage((Language) language.random());
            climbers.add(climber);
            climberRepository.save(climber);

//-----------------------------------CLIMBING ROUTE-----------------------------------

            Climbingroute climbingroute = new Climbingroute();
            climbingroute.setClimbingRouteName(getText(20));
            climbingroute.setCreatedAt(date);
            climbingroutes.add(climbingroute);
            climbingroute.setLatitude(getLatitude(100));
            climbingroute.setLongitude(getLongitude(20) + 100);
            climbingroute.setRouteType((RouteType) routeType.random());
            climbingroute.setZoneType((ZoneType) zoneType.random());
            climbingroute.setBonus("" + bonus.random());
            climbingroute.setCreatedAt(date);
            climbingroute.setDifficulty("" + fill(40));
            climbingroute.setInfo(getText(50));
            climbingroute.setTactical(fill(6));
            climbingroute.setTechnical(fill(6));
            climbingroute.setPhysical(fill(6));
            climbingroute.setMental(fill(6));
            climbingroute.setStar(fill(6));

            climbingrouteRepository.save(climbingroute);
//-----------------------------------CARD-----------------------------------
            for (int j = 0; j < 10; j++) {
                Card card = new Card();
                CardPk cardPk = new CardPk();
                cardPk.setClimber(climber);
                cardPk.setClimbingroute(climbingroute);
                card.setId(cardPk);
                card.setBonus("" + bonus.random());
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

        User admin = new User();
        admin.setEmail("" + getName(6) + "@" + "gmail.com");
        admin.setUsername("francois");
        admin.setPassword("francois");
        admin.setAuthorities("ACCESS_ADMIN");
        admin.setRoles("ADMIN");

        User yannael = new User();
        yannael.setEmail("" + getName(6) + "@" + "gmail.com");
        yannael.setUsername("yannael");
        yannael.setPassword("yannael");
        yannael.setAuthorities("ACCESS_MANAGER");
        yannael.setRoles("MANAGER");

        User adrien = new User();
        adrien.setEmail("" + getName(6) + "@" + "gmail.com");
        adrien.setUsername("adrien");
        adrien.setPassword("adrien");
        adrien.setAuthorities("ACCESS_MANAGER");
        adrien.setRoles("MANAGER");

        User florian = new User();
        florian.setEmail("" + getName(6) + "@" + "gmail.com");
        florian.setUsername("florian");
        florian.setPassword("florian");
        florian.setAuthorities("ACCESS_MANAGER");
        florian.setRoles("MANAGER");

        List<User> users = Arrays.asList(admin, adrien, florian, yannael);
        userRepository.saveAll(users);

        for (int k = 0; k < 10 ; k++) {
            User user1 = new User();
            user1.setEmail("" + getName(6) + "@" + "gmail.com");
            user1.setUsername(getName((10)) + fill(4));
            user1.setPassword(getName(8));
            user1.setAuthorities("");
            user1.setRoles("USER");
            userRepository.save(user1);
        }
    }
}
