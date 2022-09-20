package com.controller.impl;


import com.business.BranchBusiness;
import com.controller.BranchController;
import com.dto.request.BranchReq;
import com.dto.response.BranchRes;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class BranchControllerImpl implements BranchController {

    @Autowired
    BranchBusiness branchBusiness;



    @Override
    @PostMapping("/create/branch/name")
    public GeneralResponse createBranch(@RequestBody BranchReq branchReq) {
        return branchBusiness.createBranch(branchReq);
//        return GeneralResponse.generateResponse(branchReq,112,"121212");
    }

    @Override
    @GetMapping("branch/get/all/details")
    public GeneralResponse getBranchDetails() {
        return branchBusiness.getBranchDetails();
    }
}
