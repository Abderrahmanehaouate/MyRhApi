package com.youcode.myrhapi.services.interfaces;

import com.youcode.myrhapi.models.Dtos.CompanyDto.CompanyDto;
import com.youcode.myrhapi.models.Entities.VerifiedAccount;

public interface CompanyService extends BaseService<CompanyDto>{
    void verifyCompanyAccount(VerifiedAccount verifiedAccount);
}
