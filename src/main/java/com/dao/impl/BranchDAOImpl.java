package com.dao.impl;

import com.dao.BranchDAO;
import com.dao.VehicleDAO;
import com.dto.request.BranchReq;
import com.dto.response.BranchRes;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BranchDAOImpl implements BranchDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public GeneralResponse createBranch(BranchReq branchReq) {
        GeneralResponse generalResponse = null;

        int isInserted = 0;

        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.IBranch.INSERT_BRANCH_NAME,
                    branchReq.getBranchName());

            if(isInserted == 1) {
                generalResponse = GeneralResponse.generateResponse(
                        null,1000,"Sucessfully Created"
                );
            }
            else {
                generalResponse = GeneralResponse.generateResponse(null,1001,
                        "Branch name not added try again");
            }

        }catch (Exception exception) {
            exception.printStackTrace();
            generalResponse = GeneralResponse.generateResponse(null,1001,
                    "Branch name not added system failure");
        }


        return generalResponse;
    }

    @Override
    public GeneralResponse getBranchDetails() {
        GeneralResponse response = null;
        List<BranchRes> branchRes = new ArrayList<>();

        try{
            branchRes = jdbcTemplate.query(ApplicationDAOContant.IBranch.GET_ALL_BRANCH_DETAILS,
                    (rs, rowNum) -> new BranchRes(rs.getInt("BranchId"),rs.getString("BranchName")));


                response = GeneralResponse.generateResponse(branchRes, 1000, "sucess");

        }catch (Exception e) {

        }

        return response;
    }
}
