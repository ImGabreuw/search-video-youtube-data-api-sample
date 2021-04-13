package me.gabreuw.search_video_youtube_data_api_sample.domain;

import lombok.Data;
import me.gabreuw.search_video_youtube_data_api_sample.domain.enums.YouTubeURL;

import java.io.Serializable;

@Data
public class Channel implements Serializable {

    private String title;
    private String url;

    public Channel(String channelTitle, String channelId) {
        this.title = channelTitle;
        this.url = YouTubeURL.CHANNEL.format(channelId);
    }
}
