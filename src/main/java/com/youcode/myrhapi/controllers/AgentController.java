package com.youcode.myrhapi.controllers;

import com.youcode.myrhapi.models.Dtos.AgentDto.AgentDto;
import com.youcode.myrhapi.services.interfaces.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/agents")
public class AgentController {
    private  final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }
    @GetMapping
    public List<AgentDto> getAllAgents(@PathVariable int page, @PathVariable int pageSize, @PathVariable String sortBy){

        return agentService.getAllAgents(page, pageSize, sortBy);
    }
    @GetMapping("/{id}")
    public Optional<AgentDto> getAgentById(@PathVariable Long id){

        return agentService.getById(id);
    }

    @PostMapping("/create")
    public Optional<AgentDto> createAgent(@RequestBody AgentDto agentDto){

        return agentService.create(agentDto);
    }
    @PutMapping("/update")
    public Optional<AgentDto> updateAgent(@RequestBody AgentDto agentDto){

        return agentService.update(agentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAgentById(@PathVariable Long id){
        agentService.deleteById(id);
    }
}
