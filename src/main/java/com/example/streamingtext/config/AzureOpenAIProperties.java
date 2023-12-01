package com.example.streamingtext.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.Map;

@Slf4j
@Getter
@ConfigurationProperties(prefix = "engine.chat-gpt.azure-open-ai")
public class AzureOpenAIProperties {
    private final Map<String, AzureOpenAIServiceProperties> services;

    @ConstructorBinding
    public AzureOpenAIProperties(Map<String, AzureOpenAIServiceProperties> services) {
        this.services = services;
    }

    @Getter
    public static class AzureOpenAIServiceProperties {
        private final String name;
        private final String model;
        private final String apiVersion;
        private final String apiKey;
        private final String endpoint;
        private final String developmentName;

        @ConstructorBinding
        public AzureOpenAIServiceProperties(String name, String model, String apiVersion, String apiKey, String endpoint, String developmentName) {
            this.name = name;
            this.model = model;
            this.apiVersion = apiVersion;
            this.apiKey = apiKey;
            this.endpoint = endpoint;
            this.developmentName = developmentName;
        }
    }
}
