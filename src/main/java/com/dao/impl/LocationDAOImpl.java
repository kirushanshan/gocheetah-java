package com.dao.impl;

import com.dao.LocationDAO;
import com.dto.request.CityAddReq;
import com.dto.request.LocationReq;
import com.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationDAOImpl implements LocationDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public GeneralResponse createCity(CityAddReq cityAddReq) {
        GeneralResponse generalResponse= null;
        int isInserted = 0;

        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.ILocation.INSERT_CITY_NAME,
                    cityAddReq.getBranchId(),cityAddReq.getCityName());

            if(isInserted == 1) {
                generalResponse = GeneralResponse.generateResponse(null,1000,
                        "sucessfully city name added");
            }
            else  {
                generalResponse = GeneralResponse.generateResponse(null,1001,
                        "City name not added, try again");
            }

        }catch (Exception exception) {
                generalResponse = GeneralResponse.generateResponse(exception,1001,
                    "City name not added, system error");
        }
        return generalResponse;
    }

    @Override
    public GeneralResponse createLocation(LocationReq locationReq) {
        GeneralResponse response = null;
        int isInserted = 0;

        try {
            isInserted = jdbcTemplate.update(ApplicationDAOContant.ILocation.INSERT_LOCATION_DEATAILS,
                    locationReq.getLocationName(),locationReq.getStreetAddress(),
                    locationReq.getCityId(),locationReq.getBranchId(),locationReq.getLocationTag());

            if(isInserted == 1) {
                response = GeneralResponse.generateResponse(null, 1000, "Sucessfully" +
                        "location added");
            }
            else{
                    response = GeneralResponse.generateResponse(null,1001,"Location " +
                            "Details add unsucessfull try again");
            }


        }catch (Exception exception) {
            response = GeneralResponse.generateResponse(locationReq,1001,"Location " +
                    "Details add unsucessfull system error");
        }
        return response;
    }

    @Override
    public GeneralResponse getCityByBranchId(int id) {
        GeneralResponse response = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<CityGetRes> cityGetResList = new ArrayList<>();
        String sql = "SELECT CityId, CityName FROM city WHERE BranchId=" + String.valueOf(id);
        try {
           connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
           statement = connection.createStatement();
           resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                CityGetRes cityGetRes = new CityGetRes();
                cityGetRes.setCityId(resultSet.getInt(1));
                cityGetRes.setCityName(resultSet.getString(2));


                cityGetResList.add(cityGetRes);

            }
            response = GeneralResponse.generateResponse(cityGetResList,1000,"suceess fully get");
        }catch (Exception e) {
            response = GeneralResponse.generateResponse(e,1001,"unSucess");
        }

        return response;
    }

    @Override
    public GeneralResponse getLocationDetailsByCityId(int id) {
        GeneralResponse response = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<LocationRes> locationResList = new ArrayList<>();

        String sql = "SELECT LocationId,StreetAddress FROM location WHERE cityId = "+ String.valueOf(id);
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                LocationRes locationRes = new LocationRes();
                locationRes.setLocationId(resultSet.getInt(1));
                locationRes.setStreetAddress(resultSet.getString(2));

                locationResList.add(locationRes);
            }

            response = GeneralResponse.generateResponse(locationResList,1000,"Sucess");

        }catch (Exception exception) {
            response = GeneralResponse.generateResponse(exception,1001,"UnSucess get Location");
        }

        return response;
    }
}
