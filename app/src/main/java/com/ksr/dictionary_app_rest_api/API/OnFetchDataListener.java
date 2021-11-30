package com.ksr.dictionary_app_rest_api.API;

import com.ksr.dictionary_app_rest_api.Models.ApiResponse;

public interface OnFetchDataListener {
    void onFetchData(ApiResponse apiResponse, String message);
    void onError(String message);

}
