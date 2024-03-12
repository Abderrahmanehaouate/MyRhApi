package com.youcode.myrhapi.security;

import com.youcode.myrhapi.models.Dtos.AgentDto.AgentDto;
import com.youcode.myrhapi.models.Dtos.Authentification.AuthDto;
import com.youcode.myrhapi.models.Dtos.Authentification.LoginDto;
import com.youcode.myrhapi.models.Dtos.CompanyDto.CompanyDto;
import com.youcode.myrhapi.models.Dtos.CondidatDto.CondidatDto;
import com.youcode.myrhapi.models.Entities.Agent;
import com.youcode.myrhapi.models.Entities.Candidate;
import com.youcode.myrhapi.models.Entities.Company;
import com.youcode.myrhapi.repositories.AgentRepository;
import com.youcode.myrhapi.repositories.CompanyRepository;
import com.youcode.myrhapi.repositories.CondidateRepository;
import com.youcode.myrhapi.services.interfaces.AgentService;
import com.youcode.myrhapi.services.interfaces.CandidateService;
import com.youcode.myrhapi.services.interfaces.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AgentRepository agentRepository;
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;
    private final CondidateRepository condidateRepository;
    private final CandidateService candidateService;
    private final AgentService agentService;
    private final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(AgentRepository agentRepository, ModelMapper modelMapper, CompanyRepository companyRepository, CondidateRepository condidateRepository, CandidateService candidateService, AgentService agentService, CompanyService companyService, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.agentRepository = agentRepository;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
        this.condidateRepository = condidateRepository;
        this.candidateService = candidateService;
        this.agentService = agentService;
        this.companyService = companyService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthDto registerCompany(CompanyDto registerRequest) {
        Company company = modelMapper.map(registerRequest, Company.class);
        company.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);

        companyService.create(companyDto);

        String jwtToken = jwtService.generateToken(company);

        AuthDto authDto = new AuthDto();
        authDto.setToken(jwtToken);
        return authDto;
    }

    public AuthDto registerAgent(AgentDto registerRequest) {
        Agent agent = modelMapper.map(registerRequest, Agent.class);
        agent.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        AgentDto agentDto = modelMapper.map(agent, AgentDto.class);

        agentService.create(agentDto);

        String jwtToken = jwtService.generateToken(agent);

        AuthDto authDto = new AuthDto();
        authDto.setToken(jwtToken);
        return authDto;
    }

    public AuthDto registerCandidate(CondidatDto registerRequest) {
        Candidate condidate = modelMapper.map(registerRequest, Candidate.class);
        condidate.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        CondidatDto condidatDto = modelMapper.map(condidate, CondidatDto.class);

        candidateService.create(condidatDto);

        String jwtToken = jwtService.generateToken(condidate);

        AuthDto authDto = new AuthDto();
        authDto.setToken(jwtToken);
        return authDto;
    }

    public AuthDto login(LoginDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(userDetails);

        AuthDto authDto = new AuthDto();
        authDto.setToken(jwtToken);

        return authDto;
    }
}
