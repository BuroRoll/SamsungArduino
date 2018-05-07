package com.example.buror.samsungproject.FeedBack;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SpreadsheetWebService {

    @POST("1FAIpQLScQmw1yU7ecjQ9Fk7VYq1FnZH1pR_EpInhvp1l4Bl9WMURaPQ/formResponse")
    @FormUrlEncoded
    Call<Void> feedbackSend(
            @Field("entry.1686190608") String feedback,
            @Field("entry.994787983") String name,
            @Field("entry.645718747") String email
    );

}
