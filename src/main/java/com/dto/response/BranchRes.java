package com.dto.response;

public class BranchRes {
    int branchId;
    String branchName;

    public BranchRes(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
