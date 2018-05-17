package com.example.shubham.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shubham.news.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<NewsArticle> newsArticles = new ArrayList<>();
        newsArticles.add(new NewsArticle("Zuckerberg will meet with European parliamen",
                "Who says privacy is dead? Facebook’s founder Mark Zuckerberg has agreed to take European parliamentarians’ questions about how his platform impacts the privacy of hundreds of millions of European citizens — but only behind closed doors. Where no one except a handful of carefully chosen MEPs will bear witness to what’s said.",
                "https://techcrunch.com/wp-content/uploads/2018/04/gettyimages-944402874.jpeg",
                "Today",
                "https://techcrunch.com/2018/05/17/zuckerberg-will-meet-with-european-parliament-in-private-next-week/"));

        newsArticles.add(new NewsArticle("Instagram opens a San Francisco office",
                "Last year, Facebook was reportedly scouting for office space in San Francisco in order to find a space suitable to house some 100 Instagram employees. Today, the company is officially confirming its San Francisco plans with an announcement that it has leased four floors at 181 Fremont in San Francisco.",
                "https://techcrunch.com/wp-content/uploads/2018/05/20180511_igsf_officespace-234.jpg",
                "Today",
                "https://techcrunch.com/2018/05/17/instagram-opens-a-san-francisco-office/"));

        NewsStore.setNewsArticles(newsArticles);

        newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticles());
        newsRecyclerView.setAdapter(homeNewsAdapter);
    }
}
