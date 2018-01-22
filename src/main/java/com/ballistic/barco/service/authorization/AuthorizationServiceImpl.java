package com.ballistic.barco.service.authorization;

import com.ballistic.barco.domain.User;
import com.ballistic.barco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nabeel on 1/22/2018.
 */
@Service
public class AuthorizationServiceImpl implements IAuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public String register(User user) {
        userRepository.save(user);
        return "{status:save}";
    }
}
