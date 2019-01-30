package com.shreyaghoshal.twopointo.error;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ErrorInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!response.isSuccessful()) {
            throw new SGAppError(
                    response.code(),
                    response.message()
            );
        }
        return response;
    }
    }
