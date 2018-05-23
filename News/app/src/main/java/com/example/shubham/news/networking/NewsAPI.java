package com.example.shubham.news.networking;

import com.example.shubham.news.model.GetArticlesResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class NewsAPI {
    private static final String APIKEY = "af6398dd897749d98e4d262999317a15";
    private static final String APIPATH = "https://newsapi.org/v2/";

    private static NewsService newsService = null;

    public static NewsService getApi() {
        if (newsService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIPATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsService = retrofit.create(NewsService.class);
        }
        return newsService;
    }

    public interface NewsService {
        @GET("top-headlines?apiKey=" + APIKEY)
        Call<GetArticlesResponse> getArticles(@Query("sources") String sources, @Query("sortBy") String sortBy);
    }
}
