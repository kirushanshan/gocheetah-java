package com.dao.impl;

public class ApplicationDAOContant {

    interface IVehicle {
         String INSERT_VEHICLE_CATEGORY = "INSERT INTO vechicle_category(VechicleCategoryName) VALUES (?)";
         String GET_VEHICLE_CATEGORIES = "SELECT VechicleCategoryId,VechicleCategoryName from vechicle_category";
        String INSERT_VEHICLE_DETAIL = "INSERT INTO vechicle_detail (BrandName,ModelName,VechicleCategoryId) VALUES(?,?,?)";

        String GET_VEHICLE_DETAIL = "select vd.VechicleDetailId,vd.BrandName,vd.ModelName,v.VechicleCategoryName from vechicle_detail vd inner join vechicle_category v \n" +
                "on vd.VechicleCategoryId = v.VechicleCategoryId where VechicleDetailId = ";

        String GET_VEHICLE_DETAIL_LIST = "select vd.VechicleDetailId,vd.BrandName,vd.ModelName,v.VechicleCategoryName from vechicle_detail vd inner join vechicle_category v \n" +
                "on vd.VechicleCategoryId = v.VechicleCategoryId";

        String DELETE_VEHICLE_DETAIL = "DELETE FROM vechicle_category WHERE VechicleCategoryId = ?";
        String UPDATE_VEHICLE_CATEGORY_DETAIL = "UPDATE vechicle_category SET VechicleCategoryName = ? WHERE `VechicleCategoryId` = ?";

        String UPDATE_VEHICLE_DETAIL = "UPDATE vechicle_detail SET BrandName = ?, ModelName = ?, VechicleCategoryId = ? WHERE VechicleDetailId = ?";
    }

    interface IBranch {
        String INSERT_BRANCH_NAME= "INSERT INTO branch (BranchName) VALUES (?)";

        String GET_ALL_BRANCH_DETAILS = "SELECT * FROM branch";
    }

    interface ILocation {
        String INSERT_CITY_NAME = "INSERT INTO city (BranchId,CityName) VALUES (?,?)";
        String INSERT_LOCATION_DEATAILS = "INSERT INTO location (LocationName,StreetAddress,CityId,BranchId,locationTag) VALUES (?,?,?,?,?)";


    }

    interface ITrip {
        String INSERT_TRIP = "insert into trip(SourceLocationId, DestinationLocationId, TravelDateTime, TripFare, TripStatus, BranchId, UserDetailId) VALUES (?,?,?,?,?,?,?)";


        String EDIT_TRIP = "";

        String CANCEL_TRIP = "";

        String TRIP_LIST = "";

        String TRIP_DETAIL = "";
        String GET_LOCATIONS = "select LocationId,StreetAddress,City from location";
        String GET_LOCATIONS_BY_CITY = "select LocationId, StreetAddress from location where City = ";
    }
}
