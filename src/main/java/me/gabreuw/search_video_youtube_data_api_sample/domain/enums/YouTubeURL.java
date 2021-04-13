package me.gabreuw.search_video_youtube_data_api_sample.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum YouTubeURL {
    WATCH_VIDEO("https://www.youtube.com/watch?v=%s") {
        @Override
        public String format(String value) {
            return String.format(getBASE_URL(), value);
        }
    },
    CHANNEL("https://www.youtube.com/channel/%s") {
        @Override
        public String format(String value) {
            return String.format(getBASE_URL(), value);
        }
    };

    @Getter
    private final String BASE_URL;

    public abstract String format(String value);
}
