package com.saras.paytm.util;



import java.util.NoSuchElementException;

import org.springframework.security.core.userdetails.UsernameNotFoundException;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utility {
    private Utility() {
    }

    public static NoSuchElementException notFound(Integer empId) {
        log.error("Employee with id=" + empId + " not found.");
        return new NoSuchElementException("Employee with id=" + empId + " not found.");
    }

//    public static EmployeeDTO mapToEmployeeDTO(Employee emp) {
//        EmployeeDTO employeeDTO = EmployeeDTO.builder().id(emp.getId()).name(emp.getName()).address(emp.getAddress())
//                .build();
//
//        log.info("Employee details : {}", employeeDTO);
//        return employeeDTO;
//    }
//
//    public static UserInfoDTO mapToUserInfoDTO(UserInfo userInfo) {
//        UserInfoDTO userInfoDTO = UserInfoDTO.builder().id(userInfo.getId()).name(userInfo.getName())
//                .email(userInfo.getEmail()).roles(userInfo.getRoles()).build();
//        log.info("User details : {}", userInfoDTO);
//        return userInfoDTO;
//    }

    public static UsernameNotFoundException usernameNotFoundException(String msg) {
        log.error("{}", msg);
        return new UsernameNotFoundException(msg);
    }
}