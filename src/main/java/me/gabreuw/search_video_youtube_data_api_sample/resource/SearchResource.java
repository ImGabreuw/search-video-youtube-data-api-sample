package me.gabreuw.search_video_youtube_data_api_sample.resource;

import com.google.api.services.youtube.model.SearchResult;
import me.gabreuw.search_video_youtube_data_api_sample.domain.Video;
import me.gabreuw.search_video_youtube_data_api_sample.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/search")
public class SearchResource {

    @Autowired
    private SearchService service;

    @GetMapping(path = "/query/{query}")
    public ResponseEntity<SearchResult> searchByName(
            @PathVariable String query
    ) {
        SearchResult searchByName = service.searchByQuery(query);

        return ResponseEntity
                .ok()
                .body(searchByName);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Video> searchById(
            @PathVariable String id
    ) {
        com.google.api.services.youtube.model.Video video = service.searchVideoById(id);

        return ResponseEntity
                .ok()
                .body(Video.of(video));
    }


}
