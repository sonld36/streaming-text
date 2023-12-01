package com.example.streamingtext.controller;

import com.example.streamingtext.model.MessageRequest;
import com.example.streamingtext.service.impl.ChatGPTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/admin/ai_converse/chat_gpt")
@RequiredArgsConstructor
public class ChatGPTController {
    private final ChatGPTService chatGPTService;

    @PostMapping(value = "/generation", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<?> generation(@RequestBody MessageRequest messageRequest) {
        return chatGPTService.generation(messageRequest);
    }
}
