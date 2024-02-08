package com.youcode.myrhapi.security;

import com.youcode.myrhapi.models.Entities.Agent;
import com.youcode.myrhapi.models.Entities.Candidate;
import com.youcode.myrhapi.models.Entities.Company;
import com.youcode.myrhapi.repositories.AgentRepository;
import com.youcode.myrhapi.repositories.CompanyRepository;
import com.youcode.myrhapi.repositories.CondidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private CondidateRepository condidateRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Agent agent = agentRepository.findByEmail(username);
        if (agent != null) {
            return agent;
        }

        Company company = companyRepository.findByEmail(username);
        if (company != null) {
            return company;
        }

        Candidate candidate = condidateRepository.findByEmail(username);
        if (candidate != null) {
            return candidate;
        }

        throw new UsernameNotFoundException("User not found with the email " + username);
    }
}
