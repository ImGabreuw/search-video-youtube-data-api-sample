package me.gabreuw.search_video_youtube_data_api_sample.domain.factory;

import com.google.api.services.youtube.YouTube;
import lombok.SneakyThrows;

import java.io.IOException;

public class SearchFactory {
    @SneakyThrows(IOException.class)
    public static YouTube.Search.List createSearchByQuery(String query, String key) {
        YouTube.Search.List search = YouTubeFactory.create()
                .search()
                .list("id,snippet");

        search.setKey(key);
        search.setQ(query);
        search.setType("video");
        search.setFields("items(id/videoId,snippet/title,snippet/description)");
        search.setMaxResults(1L);

        return search;
    }

    @SneakyThrows(IOException.class)
    public static YouTube.Videos.List createSearchById(String id, String key) {
        YouTube.Videos.List search = YouTubeFactory.create()
                .videos()
                .list("snippet, contentDetails");

        search.setKey(key);
        search.setId(id);

        return search;
    }

}
