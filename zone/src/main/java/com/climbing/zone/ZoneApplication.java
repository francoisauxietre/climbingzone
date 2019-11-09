package com.climbing.zone;

import com.climbing.zone.domain.*;
import com.climbing.zone.enumeration.BonusType;
import com.climbing.zone.repository.CardRepository;
import com.climbing.zone.repository.ClimberRepository;
import com.climbing.zone.repository.ClimbingrouteRepository;
import net.bytebuddy.utility.RandomString;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.lang.Object;

// modification pour le docker de public class ZoneApplication extends SpringBootServletInitializer
@SpringBootApplication
public class ZoneApplication {

    class RandomEnum<E extends Enum<BonusType>> {
        Random RND = new Random();
        E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }

    @Autowired
    private ClimbingrouteRepository climbingrouteRepository;
    @Autowired
    private ClimberRepository climberRepository;
    @Autowired
    private CardRepository cardRepository;

    public static final String CONSONNES = "bcd fg hklm npqr stvw x z"; //20
    public static final String VOYELLES = "aeiouy"; //6

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

    public String getNoms(int number) {
        String returnC = "";
        for (int i = 0; i < number; i++) {
            returnC += CONSONNES.charAt(fill(24));
            returnC += VOYELLES.charAt(fill(5));
        }
        return returnC;
    }

    public void in (String imagePath){

        InsertImageTest insertImageTest = null;
        insertImageTest.insertImage();
    }


    @PostConstruct
    public void init() {
        RandomEnum<BonusType> r = new RandomEnum<BonusType>(BonusType.class);


        Set<Climber> climbers = new HashSet<>();
        Set<Climbingroute> climbingroutes = new HashSet<>();

        for (int i = 0; i < 10; i++) {
//--------------------------------CLIMBER-----------------------------
            Climber climber = new Climber();
            climber.setLastName(getNoms(2) + fill(100));
            climber.setFirstName(getNoms(3) + fill(100));
            Date date = new Date(System.currentTimeMillis());

            climber.setBirth(date);
            Climbingroute climbingroute = new Climbingroute();
            climbingroute.setName(getNoms(2) + fill(1000));

            climbers.add(climber);
            climbingroutes.add(climbingroute);
            climberRepository.save(climber);
            climbingrouteRepository.save(climbingroute);

//-----------------------------------CARD-----------------------------------
            Card card = new Card();
            CardPk cardPk = new CardPk();
            cardPk.setClimber(climber);
            cardPk.setClimbingroute(climbingroute);
            card.setId(cardPk);
            card.setBonus("" + r.random());
            card.setDate(date);
            card.setDifficuty("" + fill(40));
            card.setInfo(getNoms(50));



            card.setTactical((int) (Math.random() * 6));
            card.setTechnical((int) (Math.random() * 56));
            card.setPhysical((int) (Math.random() * 5));
            card.setMental((int) (Math.random() * 5));

            cardRepository.save(card);
        }

//
//        System.out.println(climberList.size());
//        System.out.println(climbingrouteList.size());
//
//        System.out.println("===================Students info:==================");
//        climberList.forEach(student -> System.out.println(student.toString()));
//
//        System.out.println("===================Students info:==================");

    }
}
