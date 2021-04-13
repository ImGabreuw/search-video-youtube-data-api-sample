package me.gabreuw.search_video_youtube_data_api_sample.domain.factory;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;

public class YouTubeFactory {

    public static YouTube create() {
        return new YouTube.Builder(
                new NetHttpTransport(),
                new JacksonFactory(),
                request -> {}
        ).setApplicationName("search-video-youtube-data-api-sample").build();
    }

}
