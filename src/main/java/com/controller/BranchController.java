package com.controller;

import com.dto.request.BranchReq;
import com.dto.response.BranchRes;
import com.dto.response.GeneralResponse;
import org.springframework.web.bind.annotation.RequestBody;


public interface BranchController {


    public GeneralResponse createBranch(@RequestBody BranchReq branchReq);

    GeneralResponse getBranchDetails();

//    public GeneralResponse editBranch(BranchReq branchReq);
//
//    public GeneralResponse deleteBranch();


}
