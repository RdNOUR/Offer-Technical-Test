package com.offertechnicaltest.service;

import com.offertechnicaltest.domain.User;
import com.offertechnicaltest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void registerUser() {
        //Tester l'insertion

        User user = userRepository.save(new User(14L,"e7", LocalDate.of(2000, Month.AUGUST, 10),"France",33787055003L,"Male"));
        Optional<User> genericEntityFound = userRepository.findById(user.getId());
        assertNotNull(genericEntityFound);
        assertEquals(user.getId(), genericEntityFound.get().getId());
    }

    @Test
    void getUserByName() {
        //Tester la validité des données

        User user = userRepository.save(new User(14L,"e7", LocalDate.of(2000, Month.AUGUST, 10),"USA",33787055003L,"Male"));
        Optional<User> genericEntityFound = userRepository.findById(user.getId());
        boolean expected = genericEntityFound.isPresent();
        if(user.getCountryOfResidence().equals("France") && user.getBirthdate().isBefore(LocalDate.parse("2003-12-31"))){
            assertThat(expected).isTrue();
        }else{
            assertThat(expected).isFalse();
        }
    }
}