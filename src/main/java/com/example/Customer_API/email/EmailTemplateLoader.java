package com.example.Customer_API.email;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class EmailTemplateLoader {

    private final ResourceLoader resourceLoader;

    public EmailTemplateLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String loadTemplate(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource(filePath);
        return new String(Files.readAllBytes(Paths.get(resource.getURI())));
    }

    public String replacePlaceholders(String template, String name, String resetLink) {
        return template.replace("{{name}}", name)
                .replace("{{resetLink}}", resetLink);
    }
}
