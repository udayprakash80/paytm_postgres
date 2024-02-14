package com.saras.paytm.service;

import com.saras.paytm.config.UserUserDetails;
import com.saras.paytm.entity.PaytmUser;
import com.saras.paytm.repository.UserRepository;
import com.saras.paytm.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;


    public PaytmUser addUser(PaytmUser paytmUser) {
        paytmUser.setPassword(encoder.encode(paytmUser.getPassword()));

//        User userInfo = User.builder().userName(user.getUserName())
//                .password(user.getPassword())
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName()).build();
		return userRepository.save(paytmUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PaytmUser> user = userRepository.findByUserName(username);

        return user.map(UserUserDetails::new)
                .orElseThrow(() -> Utility.usernameNotFoundException("Given user not found : " + username));
    }
}
