package com.example.streamingtext.config;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AzureOpenAIServiceConfigs {
    private String serviceName;
    private String model;
    private String apiVersion;
    private String apiKey;
    private String endpoint;
    private String developmentName;
}

