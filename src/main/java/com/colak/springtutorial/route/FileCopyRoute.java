package com.colak.springtutorial.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileCopyRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("file:src/main/resources/input?noop=true") // Read from input directory, noop=true to avoid deletion
                .log("Copying file: ${header.CamelFileName}")
                .to("file:src/main/resources/output") // Write to output directory
                .log("File copied to output folder");
    }
}
