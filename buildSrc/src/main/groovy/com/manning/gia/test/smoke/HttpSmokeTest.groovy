package com.manning.gia.test.smoke

import groovyx.net.http.HTTPBuilder

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import static groovyx.net.http.ContentType.TEXT

class HttpSmokeTest extends DefaultTask {
    @Input
    String url
    
    @Input
    String errorMessage
    
    @TaskAction
    void letThereBeSmoke() {
        boolean success = isUp(url)
        if(!success) {
            throw new GradleException(errorMessage)
        }
    }
    private boolean isUp(String url) {
        logger.info("smoking url: " + url)
        def http = new HTTPBuilder(url)
        def responseStatus = http.get(contentType: TEXT) { resp, reader ->
            logger.info("response " + resp)
            logger.info("response status " + resp.status)
            resp.status
        }
        logger.info("response status " + responseStatus)
        logger.info("HttpURLConnection.HTTP_OK " + HttpURLConnection.HTTP_OK)
        
        responseStatus == HttpURLConnection.HTTP_OK
    }
}