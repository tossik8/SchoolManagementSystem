package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.authentication.AuthenticationRequest;
import com.project.schoolManagementSystem.dto.authentication.AuthenticationResponse;
import com.project.schoolManagementSystem.dto.registration.EmployeeRegistrationRequest;
import com.project.schoolManagementSystem.dto.registration.RegistrationRequest;
import com.project.schoolManagementSystem.dto.registration.RegistrationResponse;
import com.project.schoolManagementSystem.dto.registration.StudentRegistrationRequest;
import com.project.schoolManagementSystem.entity.Employee;
import com.project.schoolManagementSystem.entity.Person;
import com.project.schoolManagementSystem.entity.Student;
import com.project.schoolManagementSystem.enumeration.Role;
import com.project.schoolManagementSystem.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final PasswordService passwordService;
    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        String username = generateUsername();
        String rawPassword = passwordService.generatePassword();
        String password = passwordEncoder.encode(rawPassword);
        Person person;
        if (request.getRole() == Role.STUDENT){
            person = new Student((StudentRegistrationRequest) request, username, password);
        }
        else{
            person = new Employee((EmployeeRegistrationRequest) request, username, password);
        }
        personRepository.save(person);
        return new RegistrationResponse(username, rawPassword);
    }

    private String generateUsername(){
        Random random = new Random();
        StringBuilder username;
        do {
            username = new StringBuilder();
            random.ints(8, 0, 9).forEach(username::append);
        } while (personRepository.findByUsername(username.toString()).isPresent());
        return username.toString();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        return new AuthenticationResponse(jwtService.generateToken(userDetails));
    }
}
