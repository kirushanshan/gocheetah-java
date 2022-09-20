package com.dao.impl;

import com.dao.VehicleDAO;
import com.dto.request.GetVehicleDetailReq;
import com.dto.request.VehicleCategoryReq;
import com.dto.request.VehicleDetailReq;
import com.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public CommonResponse createVehicleCategory(VehicleCategoryReq vehicleCategoryReq) {
        CommonResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.IVehicle.INSERT_VEHICLE_CATEGORY,
                    vehicleCategoryReq.getVehicleCategoryName());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        commonResponse = new CommonResponse();
        commonResponse.setRes(isInserted == 1? true : false);
        commonResponse.setStatusCode(isInserted == 1? 1000 : 1036);
        commonResponse.setMessage(isInserted == 1? "Success" : "Unable to create the category, please try again...!");

        return commonResponse;
    }

    @Override
    public List<VehicleCategoriesRes> getVehicleCategories() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<VehicleCategoriesRes> list = new ArrayList<>();
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.IVehicle.GET_VEHICLE_CATEGORIES);
            while (resultSet.next()){
                VehicleCategoriesRes res = new VehicleCategoriesRes();
                res.setVehicleCategoryId(resultSet.getInt(1));
                res.setVehicleCategoryName(resultSet.getString(2));

                list.add(res);
            }
        }catch (SQLException exception){

        }catch (Exception exception){

        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    @Override
    @Transactional
    public CommonResponse createVehicleDetail(VehicleDetailReq vehicleDetailReq) {
        CommonResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.IVehicle.INSERT_VEHICLE_DETAIL,
                    vehicleDetailReq.getBrandName(),vehicleDetailReq.getModelName(),vehicleDetailReq.getVehicleCategoryId());

            if(isInserted == 1){
                commonResponse = new CommonResponse(true,1000,"Success");
            }else {
                commonResponse = new CommonResponse(false,1001,"Unable to create the vehicle detail, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new CommonResponse(false,1001,"Unable to create the vehicle detail, please try again...!");
        }
        return commonResponse;
    }

    @Override
    public VehicleDetailRes getVehicleDetail(GetVehicleDetailReq getVehicleDetailReq) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        VehicleDetailRes detailRes = null;
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.IVehicle.GET_VEHICLE_DETAIL + getVehicleDetailReq.getVehicleDetailId());
            while (resultSet.next()){
                detailRes = new VehicleDetailRes();

                detailRes.setVehicleDetailId(resultSet.getInt(1));
                detailRes.setBrandName(resultSet.getString(2));
                detailRes.setModelName(resultSet.getString(3));
                detailRes.setVehicleCategoryName(resultSet.getString(4));
            }
        }catch (SQLException exception){

        }catch (Exception exception){

        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
            }
        }
        return detailRes;
    }

    @Override
    public GeneralResponse getVehicleDetails() {
        GeneralResponse response = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<VehicleDetailListRes> list = new ArrayList<>();
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.IVehicle.GET_VEHICLE_DETAIL_LIST);
            while (resultSet.next()){
                VehicleDetailListRes vehicleDetailListRes = new VehicleDetailListRes();
                vehicleDetailListRes.setVehicleDetailId(resultSet.getInt(1));
                vehicleDetailListRes.setBrandName(resultSet.getString(2));
                vehicleDetailListRes.setModelName(resultSet.getString(3));
                vehicleDetailListRes.setVehicleCategoryName(resultSet.getString(4));

                list.add(vehicleDetailListRes);
            }

            response = GeneralResponse.generateResponse(list,1000,"suceess fully get");
        }catch (SQLException exception){
            response = GeneralResponse.generateResponse(exception,1001,"unsuceess fully get");

        }catch (Exception exception){
            response = GeneralResponse.generateResponse(exception,1001,"unsuceess fully get");
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
            }
        }

        return response;

    }

    @Override
    public CommonResponse deleteVehicledetails(String userId) {
//        DELETE FROM vechicle_category WHERE VechicleCategoryId = id;
        CommonResponse commonResponse = null;
        int isDeleted = 0;
        try{
            isDeleted = jdbcTemplate.update(ApplicationDAOContant.IVehicle.DELETE_VEHICLE_DETAIL,
                    userId);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        commonResponse = new CommonResponse();
        commonResponse.setRes(isDeleted == 1? true : false);
        commonResponse.setStatusCode(isDeleted == 1? 1000 : 1036);
        commonResponse.setMessage(isDeleted == 1? "Success fully deleted" : "Unable to Delete the category, please try again...!");

        return commonResponse;
    }

    @Override
    public CommonResponse updateVehicleCategory(String userId, VehicleCategoryReq vehicleCategoryReq) {
        CommonResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.IVehicle.UPDATE_VEHICLE_CATEGORY_DETAIL,
                    vehicleCategoryReq.getVehicleCategoryName(), userId);

            if(isInserted == 1){
                commonResponse = new CommonResponse(true,1000,"Success");
            }else {
                commonResponse = new CommonResponse(false,1001,"Unable to Update the vehicle Category, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new CommonResponse(false,1001,"Unable to Update the vehicle Category, please try again...!");
        }
        return commonResponse;
    }

    @Override
    public GeneralResponse editVehicleDetail(int id, VehicleDetailListRes vehicleDetailListRes) {
        GeneralResponse response = null;
        int isInserted = 0;

        try {
            isInserted = jdbcTemplate.update(ApplicationDAOContant.IVehicle.UPDATE_VEHICLE_DETAIL,
                    vehicleDetailListRes.getBrandName(),vehicleDetailListRes.getModelName(),
                    vehicleDetailListRes.getVehicleCategoryId(),id);

            if(isInserted == 1) {
                response = GeneralResponse.generateResponse(null,1000,"Sucessfully Upadted Vehicle Details");
            }
            else  {
                response = GeneralResponse.generateResponse(null,1001,"Unsucessfull Upadted Vehicle Details");
            }
        }catch (Exception e) {
            response = GeneralResponse.generateResponse(e,1000,"Server Error Upadted Vehicle Details");
        }

        return response;
    }
}
