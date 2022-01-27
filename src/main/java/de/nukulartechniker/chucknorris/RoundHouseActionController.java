package de.nukulartechniker.chucknorris;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RoundHouseActionController {
    @NonNull
    private ServletContext servletContext;

    @ResponseBody
    @PostMapping(value = "/roundhouseaction", produces = "image/png", consumes = "application/json")
    public ResponseEntity<Resource> getImageAsResource(@RequestBody RoundHouseAction action) {
        HttpHeaders headers = new HttpHeaders();

        String imagepath = "/WEB-INF/images/bad_ass.png";

        switch (action.getAction()) {
            case ALERT -> imagepath = "/WEB-INF/images/alert.png";
            case SUCCESS -> imagepath = "/WEB-INF/images/thumb_up.png";
            case FAIL -> imagepath = "/WEB-INF/images/bad_ass.png";
        }

        Resource resource = new ServletContextResource(servletContext, imagepath);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Resource> handleException(Exception e) {
        log.error("An error occurred", e);
        Resource resource = new ServletContextResource(servletContext, "/WEB-INF/images/bad_ass.png");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
