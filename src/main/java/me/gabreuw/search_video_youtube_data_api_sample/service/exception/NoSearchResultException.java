package me.gabreuw.search_video_youtube_data_api_sample.service.exception;

public class NoSearchResultException extends RuntimeException {
    public NoSearchResultException(String query) {
        super("No result for " + query);
    }
}
