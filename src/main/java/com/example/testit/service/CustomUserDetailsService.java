package com.example.testit.service;

import com.example.testit.model.User;
import com.example.testit.repository.UserRepository;
import com.example.testit.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import static com.example.testit.adapter.mail.MailServiceFake.logger;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Load user by username: ", username);
        User myUser = userRepository.findByUsername(username);

        if (myUser == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
        }

        return new MyUserPrincipal(myUser);
    }
}