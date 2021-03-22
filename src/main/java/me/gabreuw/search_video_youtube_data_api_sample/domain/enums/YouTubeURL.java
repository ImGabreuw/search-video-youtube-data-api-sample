package me.gabreuw.search_video_youtube_data_api_sample.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum YouTubeURL {
    WATCH_VIDEO("https://www.youtube.com/watch?v=%s") {
        @Override
        public String format(String value) {
            return String.format(getURL(), value);
        }
    };

    @Getter
    private final String URL;

    public abstract String format(String value);
}
