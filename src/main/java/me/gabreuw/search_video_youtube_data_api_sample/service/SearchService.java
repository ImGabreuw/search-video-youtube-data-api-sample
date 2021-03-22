package me.gabreuw.search_video_youtube_data_api_sample.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Video;
import lombok.SneakyThrows;
import me.gabreuw.search_video_youtube_data_api_sample.domain.factory.SearchFactory;
import me.gabreuw.search_video_youtube_data_api_sample.service.exception.NoSearchResultException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Value("${youtube.api.key}")
    private String key;

    @SneakyThrows(IOException.class)
    public SearchResult searchByQuery(String query) {
        YouTube.Search.List searchByQuery = SearchFactory.createSearchByQuery(query, key);

        List<SearchResult> searchResults = searchByQuery.execute().getItems();

        return Optional.ofNullable(searchResults)
                .filter(results -> !results.isEmpty())
                .map(results -> results.get(0))
                .orElseThrow(() -> new NoSearchResultException(query));
    }

    @SneakyThrows(IOException.class)
    public Video searchVideoById(String id) {
        YouTube.Videos.List searchById = SearchFactory.createSearchById(id, key);

        List<Video> videos = searchById.execute().getItems();

        return Optional.ofNullable(videos)
                .filter(results -> !results.isEmpty())
                .map(results -> results.get(0))
                .orElseThrow(() -> new NoSearchResultException(id));
    }

}
