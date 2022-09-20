package com.business;

import com.dto.request.*;
import com.dto.response.GeneralResponse;

public interface TripBusiness {

    GeneralResponse createNewTrip(CreateTripReq createTripReq);

    GeneralResponse editTrip(EditTripReq editTripReq);

    GeneralResponse assignDriverToTrip(AssignDriverReq assignDriverReq);

    GeneralResponse cancelTrip(CancelTripReq cancelTripReq);

    GeneralResponse getTripDetail(TripDetailReq tripDetailReq);

    GeneralResponse getLocationListByCity(GetLocationByCityReq getLocationByCityReq);

    GeneralResponse tripRequest(TripRequestReq tripRequestReq);

    GeneralResponse getTripDetails(int tripId);
}
