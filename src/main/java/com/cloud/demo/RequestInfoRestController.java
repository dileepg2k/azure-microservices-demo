package com.cloud.demo;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request")
public class RequestInfoRestController {
    private static final Logger LOGGER = LogManager.getLogger(RequestInfoRestController.class.getName());

    @GetMapping("/info")
    public ResponseEntity<Map> info(@RequestParam(value = "name", required = false) String name,
            HttpServletRequest request) {
        LOGGER.debug("/api/request/info :: starting");
        Map<String, String> requestInfoMap = new LinkedHashMap();
        Enumeration<String> headerNames = request.getHeaderNames();
        String requestId = UUID.randomUUID().toString();
        LOGGER.debug(String.format("/api/request/info :: requestId -> {%s} ", requestId));
        LOGGER.debug("Preparing entries");
        requestInfoMap.put("RequestId", requestId);
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            requestInfoMap.put(headerName, headerValue);
        }
        return new ResponseEntity<>(requestInfoMap, HttpStatus.OK);
    }
}
