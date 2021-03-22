package me.gabreuw.search_video_youtube_data_api_sample.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.gabreuw.search_video_youtube_data_api_sample.domain.enums.YouTubeURL;
import me.gabreuw.search_video_youtube_data_api_sample.util.DateHelper;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Data
public class Video implements Serializable {

    private String id;

    private String title;
    private String description;
    private String link;
    private String duration;

    public static Video of(com.google.api.services.youtube.model.Video video) {
        return new Video(
                video.getId(),
                video.getSnippet().getTitle(),
                video.getSnippet().getDescription(),
                YouTubeURL.WATCH_VIDEO.format(video.getId()),
                DateHelper.getVideoDurationFromDateFormatted(video.getContentDetails().getDuration())
        );
    }

}
