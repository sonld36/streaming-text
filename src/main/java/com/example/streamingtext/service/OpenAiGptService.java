package com.example.streamingtext.service;

import com.example.streamingtext.model.MessageRequest;
import reactor.core.publisher.Flux;

public interface OpenAiGptService {
    Flux<?> completions(MessageRequest messageRequest);
}
