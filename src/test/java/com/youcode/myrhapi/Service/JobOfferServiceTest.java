package com.youcode.myrhapi.Service;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.myrhapi.models.Entities.JobOffer;
import com.youcode.myrhapi.repositories.JobOfferRepository;
import com.youcode.myrhapi.services.JobOfferServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JobOfferServiceTest {
    @Mock
    private JobOfferRepository jobOfferRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private JobOfferServiceImp jobOfferService;

    @Test
    void testGetAllJobOffers() {
        int page = 0;
        int pageSize = 5;
        String sortBy = "id";
        String search = "";

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        List<JobOffer> jobOfferList = Arrays.asList(new JobOffer(), new JobOffer());
        Page<JobOffer> jobOfferPage = new PageImpl<>(jobOfferList, pageRequest, jobOfferList.size());

        when(jobOfferRepository.findAll(pageRequest)).thenReturn(jobOfferPage);

        List<JobOfferDto> result = jobOfferService.getAllJobOffers(page, pageSize, sortBy, search);

        assertEquals(jobOfferList.size(), result.size());
        verify(modelMapper, times(jobOfferList.size())).map(any(), eq(JobOfferDto.class));
    }

    @Test
    void testGetById() {

        Long jobId = 1L;

        JobOffer jobOffer = new JobOffer();
        when(jobOfferRepository.findById(jobId)).thenReturn(Optional.of(jobOffer));

        Optional<JobOfferDto> result = jobOfferService.getById(jobId);

        verify(modelMapper, times(1)).map(any(), eq(JobOfferDto.class));
        assertEquals(jobOffer, result);
    }
}
