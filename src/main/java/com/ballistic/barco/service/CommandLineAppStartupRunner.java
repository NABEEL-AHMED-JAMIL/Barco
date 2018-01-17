package com.ballistic.barco.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 1/12/2018.
 */
// No Issue work fine
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    // play ground for jdbc.... hint password:123
    @Override
    public void run(String...args) throws Exception {
//        log.info("Store info in db");
//        User user = new User();
//        user.setFirstname("Nabeel");
//        user.setLastname("Ahmed");
//        user.setEmail("nabeel.amd93@gmail.com");
//        user.setUsername("nabeel.amd93");
//        user.setActivated(true);
//        user.setPassword(passwordEncoder.encode("ballistic"));
//        userRepository.save(user);
    }
}