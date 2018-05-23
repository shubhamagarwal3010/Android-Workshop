package com.example.shubham.news;

import com.example.shubham.news.model.Article;

import java.util.ArrayList;
import java.util.List;

public class NewsStore {
    private static List<Article> newsArticles = new ArrayList<>();

    public static List<Article> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<Article> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
