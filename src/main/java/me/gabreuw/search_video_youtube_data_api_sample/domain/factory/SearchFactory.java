package me.gabreuw.search_video_youtube_data_api_sample.domain.factory;

import com.google.api.services.youtube.YouTube;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SearchFactory {

    @Value("${youtube.key}")
    private String key;

    @SneakyThrows(IOException.class)
    public YouTube.Search.List createRequestWithQuery(String query) {
        YouTube.Search.List videoId = YouTubeFactory.create()
                .search()
                .list("id");

        videoId.setKey(key);
        videoId.setQ(query);
        videoId.setType("video");
        videoId.setMaxResults(1L);

        return videoId;
    }

    @SneakyThrows(IOException.class)
    public YouTube.Videos.List createRequestWithVideoId(String videoId) {
        YouTube.Videos.List search = YouTubeFactory.create()
                .videos()
                .list("snippet,contentDetails,statistics");

        search.setKey(key);
        search.setId(videoId);

        return search;
    }

}
