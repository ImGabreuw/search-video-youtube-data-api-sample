package me.gabreuw.search_video_youtube_data_api_sample.domain;

import com.google.api.services.youtube.model.Video;
import lombok.Builder;
import lombok.Getter;
import me.gabreuw.search_video_youtube_data_api_sample.domain.enums.YouTubeURL;
import me.gabreuw.search_video_youtube_data_api_sample.util.DateHelper;

import java.io.Serializable;

@Builder
@Getter
public class VideoDTO implements Serializable {

    private final String title;
    private final String description;
    private final String duration;
    private final String url;

    private final Channel channel;

    public static VideoDTO of(Video video) {
        return VideoDTO.builder()
                .title(video.getSnippet().getTitle())
                .description(video.getSnippet().getDescription())
                .duration(DateHelper.getVideoDurationFromDateFormatted(
                        video.getContentDetails().getDuration()
                ))
                .url(YouTubeURL.WATCH_VIDEO.format(video.getId()))
                .channel(new Channel(
                        video.getSnippet().getChannelTitle(),
                        video.getSnippet().getChannelId()
                ))
                .build();
    }
}
