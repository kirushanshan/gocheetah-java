package com.dao.impl;

import com.dao.TripDAO;
import com.dto.request.*;
import com.dto.response.GeneralResponse;
import com.dto.response.TripRes;
import com.dto.response.VehicleDetailListRes;
import com.dto.response.VehicleDetailRes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class TripDAOImpl implements TripDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public GeneralResponse createNewTrip(CreateTripReq createTripReq) {
        GeneralResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.ITrip.INSERT_TRIP,
                    createTripReq.getSourceLocationId(),
                    createTripReq.getDestinationLocationId(),
                    createTripReq.getTravelDateTime(),
                    calculateCost(),
                    "confirm",
                    createTripReq.getBranchId(),
                    createTripReq.getUserDetailId()
            );

            if(isInserted == 1){
                commonResponse = new GeneralResponse(null,1000,"Success");
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
        }
        return commonResponse;
    }


    @Override
    public GeneralResponse editTrip(EditTripReq editTripReq) {
        return null;
    }

    @Override
    public GeneralResponse assignDriverToTrip(AssignDriverReq assignDriverReq) {
        return null;
    }

    @Override
    public GeneralResponse cancelTrip(CancelTripReq cancelTripReq) {
        return null;
    }

    @Override
    public GeneralResponse getTripDetail(TripDetailReq tripDetailReq) {
        return null;
    }

    @Override
    public GeneralResponse getLocationListByCity(GetLocationByCityReq getLocationByCityReq) {
        return null;
    }

    double calculateCost(){
        return 13.0;
    }


    @Override
    public int assignDriverByBranch(int branchid) {
        GeneralResponse response = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Integer> drivers = new ArrayList<>();
        Random random = new Random();

        String getDriverSql = "SELECT DriverId FROM driver WHERE BranchId = "+branchid;

        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getDriverSql);

            while (resultSet.next()){
                drivers.add(resultSet.getInt(1));
            }




        }catch (Exception exception) {

        }


        return drivers.get(random.nextInt(drivers.size()));
    }


    @Override
    public int getLocationTag(int location) {
        int locationTag = 0;

        try {
            String sql = "SELECT locationTag FROM Location WHERE LocationId = "+location;
            locationTag = jdbcTemplate.queryForObject(sql,Integer.class);

        }catch (Exception exception) {

        }

        return locationTag;
    }

    @Override
    public GeneralResponse tripBook(TripRequestReq tripRequestReq, int driver, double tripFare) {
        GeneralResponse response;
        int isInserted = 0;
        int tripId=0;

        String sql = "INSERT INTO trip (SourceLocationId,DestinationLocationId,TravelDateTime,TripFare,TripStatus,DriverId,BranchId,UserDetailId) VALUES (?,?,?,?,?,?,?,?)";
        String lastId = "SELECT LAST_INSERT_ID()";

        try {

            isInserted =  jdbcTemplate.update(sql,
                    tripRequestReq.getSlocation(),tripRequestReq.getDlocation(),tripRequestReq.getTravelDateTime(),
                    tripFare,"OnGoing",driver,tripRequestReq.getBranch(),tripRequestReq.getUserId());

            if(isInserted == 1 ) {
                tripId = jdbcTemplate.queryForObject(lastId, Integer.class);

                response = GeneralResponse.generateResponse(tripId,1000,"Trip Has Confirmed");

            }
            else {
                response = GeneralResponse.generateResponse(null,1001,"Trip Booking Unsucessfull");
            }
        }
        catch (Exception exception) {
            response = GeneralResponse.generateResponse(exception,1001,"Server Error");
        }

        return response;
    }

    @Override
    public GeneralResponse getTripDetails(int tripId) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        TripRes tripRes = null;

        String sql = "SELECT tr.TripFare,tr.TravelDateTime,lo.StreetAddress,br.branchName,de.StreetAddress,us.FirstName,us.MobileNumber\n" +
                "FROM (((trip tr\n" +
                "INNER JOIN location lo ON lo.locationID = tr.SourceLocationId)\n" +
                "INNER JOIN driver dr ON tr.DriverId = dr.DriverId)\n" +
                "INNER JOIN branch br ON tr.BranchId = br.BranchId)\n" +
                "INNER JOIN location de ON  de.locationID = tr.DestinationLocationId\n" +
                "INNER JOIN userdetail us ON dr.UserDetailId = us.UserDetailId\n" +
                "where tripId =";

        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql + tripId);
            while(resultSet.next()) {
                tripRes = new TripRes();
                tripRes.setTripFare(resultSet.getDouble(1));
                tripRes.setTravelDateTime(resultSet.getString(2));
                tripRes.setSourceLocation(resultSet.getString(3));
                tripRes.setBranchName(resultSet.getString(4));
                tripRes.setDestinationLocation(resultSet.getString(5));
                tripRes.setDriverName(resultSet.getString(6));
                tripRes.setDriverPhoneNumber(resultSet.getString(7));

                return GeneralResponse.generateResponse(tripRes,1000,"Sucessfully retrived");
            }
        }catch (Exception exception) {
            return GeneralResponse.generateResponse(exception,1001,"Unscess Fully Server Error retrived");
        }
        return GeneralResponse.generateResponse("SMT",1001,"Something wrong your connecton");
    }
}


