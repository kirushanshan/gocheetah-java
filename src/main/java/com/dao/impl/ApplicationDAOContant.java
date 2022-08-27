package com.dao.impl;

public class ApplicationDAOContant {

    interface IVehicle {
         String INSERT_VEHICLE_CATEGORY = "INSERT INTO vechicle_category(VechicleCategoryName) VALUES (?)";
         String GET_VEHICLE_CATEGORIES = "SELECT VechicleCategoryId,VechicleCategoryName from vechicle_category";
        String INSERT_VEHICLE_DETAIL = "INSERT INTO vechicle_detail (BrandName,ModelName,VechicleCategoryId) VALUES(?,?,?)";

        String GET_VEHICLE_DETAIL = "select vd.VechicleDetailId,vd.BrandName,vd.ModelName,v.VechicleCategoryName from vechicle_detail vd inner join vechicle_category v \n" +
                "on vd.VechicleCategoryId = v.VechicleCategoryId where VechicleDetailId = ";

        String GET_VEHICLE_DETAIL_LIST = "select vd.BrandName,vd.ModelName,v.VechicleCategoryName from vechicle_detail vd inner join vechicle_category v \n" +
                "on vd.VechicleCategoryId = v.VechicleCategoryId";
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
