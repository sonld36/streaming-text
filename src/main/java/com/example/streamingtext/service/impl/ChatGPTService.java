package com.example.streamingtext.service.impl;

import com.example.streamingtext.config.OpenAIServiceFactory;
import com.example.streamingtext.model.MessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatGPTService {
    private final OpenAIServiceFactory openAIServiceFactory;


    public Flux<?> generation(MessageRequest messageRequest) {
        var openAiGptService = openAIServiceFactory.getDefaultEngine();
        return openAiGptService.completions(messageRequest);
    }
}
