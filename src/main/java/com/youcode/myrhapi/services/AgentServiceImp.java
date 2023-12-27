package com.youcode.myrhapi.services;

import com.youcode.myrhapi.models.Dtos.AgentDto.AgentDto;
import com.youcode.myrhapi.models.Entities.Agent;
import com.youcode.myrhapi.repositories.AgentRepository;
import com.youcode.myrhapi.services.interfaces.AgentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImp implements AgentService {

    private final AgentRepository agentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AgentServiceImp(AgentRepository agentRepository, ModelMapper modelMapper) {
        this.agentRepository = agentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AgentDto> getAll() {

        List<Agent> agents = agentRepository.findAll();

        return agents.stream()
                .map(Agent -> modelMapper.map(Agent, AgentDto.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Optional<AgentDto> getById(Long id) {

        Agent agent = agentRepository.findById(id).orElse(null);

        return Optional.ofNullable(modelMapper.map(agent, AgentDto.class));
    }

    @Override
    public Optional<AgentDto> create(AgentDto item) {

        Agent agent = modelMapper.map(item, Agent.class);
        Agent savedAgent = agentRepository.save(agent);

        return Optional.ofNullable(modelMapper.map(savedAgent, AgentDto.class));
    }

    @Override
    public Optional<AgentDto> update(AgentDto item) {

        Agent agent = modelMapper.map(item, Agent.class);
        Agent savedAgent = agentRepository.save(agent);

        return Optional.ofNullable(modelMapper.map(savedAgent, AgentDto.class));
    }

    @Override
    public void deleteById(Long id) {
        agentRepository.deleteById(id);
    }
}
