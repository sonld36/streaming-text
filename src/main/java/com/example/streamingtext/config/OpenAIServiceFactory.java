package com.example.streamingtext.config;

import com.example.streamingtext.service.OpenAiGptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OpenAIServiceFactory {
    private final ApplicationContext applicationContext;

    @Value("${engine.chat-gpt.default:azure-open-ai-gpt-35-turbo}")
    private String defaultEngine;


    public OpenAiGptService getDefaultEngine() {
        OpenAiGptService openAiGptService;
        openAiGptService = applicationContext.getBean(defaultEngine, OpenAiGptService.class);
        return openAiGptService;
    }
}
