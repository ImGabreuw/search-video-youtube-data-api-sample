package me.gabreuw.search_video_youtube_data_api_sample.resource;

import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Video;
import me.gabreuw.search_video_youtube_data_api_sample.domain.VideoDTO;
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
    private SearchService searchService;

    @GetMapping(path = "/query/{query}")
    public ResponseEntity<SearchResult> searchByQuery(
            @PathVariable String query
    ) {
        SearchResult searchByName = searchService.searchByQuery(query);

        return ResponseEntity
                .ok()
                .body(searchByName);
    }

    @GetMapping(path = "/videoId/{videoId}")
    public ResponseEntity<VideoDTO> searchByVideoId(
            @PathVariable String videoId
    ) {
        Video video = searchService.searchVideoById(videoId);

        return ResponseEntity
                .ok()
                .body(VideoDTO.of(video));
    }

    @GetMapping(path = "/{videoTitle}")
    public ResponseEntity<VideoDTO> search(
            @PathVariable String videoTitle
    ) {
        String videoId = searchService.searchByQuery(videoTitle).getId().getVideoId();
        Video video = searchService.searchVideoById(videoId);

        return ResponseEntity
                .ok()
                .body(VideoDTO.of(video));
    }

}
