package com.app.orders_service.requests;

public record BaseResponse(String [] errorMessages) {

    public boolean hasError(){
        return errorMessages != null && errorMessages.length>0;
    }


}