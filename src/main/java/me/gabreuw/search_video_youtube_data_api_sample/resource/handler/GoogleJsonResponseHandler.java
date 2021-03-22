package me.gabreuw.search_video_youtube_data_api_sample.resource.handler;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import me.gabreuw.search_video_youtube_data_api_sample.domain.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class GoogleJsonResponseHandler {

    @ExceptionHandler(GoogleJsonResponseException.class)
    public ResponseEntity<StandardError> handleGoogleJsonResponse(
            GoogleJsonResponseException exception,
            HttpServletRequest request
    ) {
        String error = String.format(
                "There was a service error: %s",
                exception.getDetails().getCode()
        );
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError standardError = new StandardError(
                Instant.now(),
                status.value(),
                error,
                exception.getDetails().getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(standardError);
    }

}
