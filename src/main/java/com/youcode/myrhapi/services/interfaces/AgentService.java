package com.youcode.myrhapi.services.interfaces;

import com.youcode.myrhapi.models.Dtos.AgentDto.AgentDto;

import java.util.List;

public interface AgentService extends BaseService<AgentDto>{
    List<AgentDto> getAllAgents(int page, int pageSize, String sortBy);
}
