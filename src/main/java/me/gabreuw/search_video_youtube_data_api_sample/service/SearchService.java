package me.gabreuw.search_video_youtube_data_api_sample.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Video;
import lombok.SneakyThrows;
import me.gabreuw.search_video_youtube_data_api_sample.domain.factory.SearchFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchFactory searchFactory;

    @SneakyThrows(IOException.class)
    public SearchResult searchByQuery(String query) {
        YouTube.Search.List request = searchFactory.createRequestWithQuery(query);

        List<SearchResult> response = request.execute().getItems();

        return response.isEmpty() ?
                null :
                response.get(0);
    }

    @SneakyThrows(IOException.class)
    public Video searchVideoById(String videoId) {
        YouTube.Videos.List request = searchFactory.createRequestWithVideoId(videoId);

        List<Video> response = request.execute().getItems();

        return response.isEmpty() ?
                null :
                response.get(0);
    }

}
