package com.example.streamingtext.config;

import com.example.streamingtext.service.OpenAiGptService;
import com.example.streamingtext.service.impl.AzureOpenAiService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {AzureOpenAIProperties.class})
public class AzureOpenAiConfiguration {
    private final AzureOpenAIProperties azureOpenAIProperties;

    public AzureOpenAiConfiguration(AzureOpenAIProperties azureOpenAIProperties) {
        this.azureOpenAIProperties = azureOpenAIProperties;
    }

    @Bean(name = "azure-open-ai-gpt-35-turbo-config")
    @ConditionalOnProperty(prefix = "engine.chat-gpt.azure-open-ai.services", name = "azure-open-ai-gpt-35-turbo.enabled")
    public AzureOpenAIServiceConfigs azureOpenAIServiceConfigs() {
        var properties = azureOpenAIProperties.getServices().get("azure-open-ai-gpt-35-turbo");
        return AzureOpenAIServiceConfigs.builder()
                .serviceName(properties.getName())
                .model(properties.getModel())
                .apiVersion(properties.getApiVersion())
                .apiKey(properties.getApiKey())
                .endpoint(properties.getEndpoint())
                .developmentName(properties.getDevelopmentName())
                .build();
    }

    @Bean(name = "azure-open-ai-gpt-35-turbo")
    @ConditionalOnBean(name = "azure-open-ai-gpt-35-turbo-config")
    public OpenAiGptService azureOpenAI35(@Qualifier("azure-open-ai-gpt-35-turbo-config") AzureOpenAIServiceConfigs serviceConfigs) {
        return new AzureOpenAiService(serviceConfigs);
    }

}
