package me.gabreuw.search_video_youtube_data_api_sample.resource.handler;

import me.gabreuw.search_video_youtube_data_api_sample.domain.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Instant;

@ControllerAdvice
public class IOHandler {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<StandardError> handleIO(
            IOException exception,
            HttpServletRequest request
    ) {
        String error = String.format(
                "There was a service error: %s",
                exception.getCause()
        );
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError standardError = new StandardError(
                Instant.now(),
                status.value(),
                error,
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(standardError);
    }

}
