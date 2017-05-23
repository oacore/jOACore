package uk.ac.core.oacore4j;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author Giorgio Basile
 * @since 23/05/2017
 */
public class Utils {

    public static final String API_KEY = "apiKey";

    public static OkHttpClient createClient(String apiKey){
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
        httpClient.interceptors().add(chain -> {
            Request request = chain.request();
            HttpUrl url = request.url().newBuilder().addQueryParameter(API_KEY, apiKey).build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        });
        return httpClient.build();
    }

}
