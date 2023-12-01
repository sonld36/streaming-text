package com.example.streamingtext.service.impl;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatMessage;
import com.azure.ai.openai.models.ChatRole;
import com.azure.core.credential.AzureKeyCredential;
import com.example.streamingtext.config.AzureOpenAIServiceConfigs;
import com.example.streamingtext.model.MessageRequest;
import com.example.streamingtext.service.OpenAiGptService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AzureOpenAiService implements OpenAiGptService {
    private final AzureOpenAIServiceConfigs azureOpenAIServiceConfigs;
    private OpenAIAsyncClient client;

    @PostConstruct
    public void init() {
        client = new OpenAIClientBuilder()
                .endpoint(azureOpenAIServiceConfigs.getEndpoint())
                .credential(new AzureKeyCredential(azureOpenAIServiceConfigs.getApiKey()))
                .buildAsyncClient();
    }

    @Override
    public Flux<?> completions(MessageRequest messageRequest) {
        String message = "Hãy tạo một bản mô tả sản phẩm cho ${productName} ${productType!}.\n" +
                "          Bản mô tả trả về dưới dạng các thẻ HTML.\n" +
                "          (Cần xác định đúng element HTML để trả về đúng tiêu đề, kiểu danh sách, kiểu bảng, ...)\n" +
                "          Bắt đầu bằng một đoạn mở đầu hấp dẫn để thu hút sự chú ý của người đọc.\n" +
                "          Nội dung cần làm nổi bật những tính năng của sản phẩm đó, giúp cho khách hàng hiểu được lợi ích mà sản phẩm mang lại.\n" +
                "          ${otherRequirement!}\n" +
                "          Hãy kiểm tra lại nội dung mà mình viết ra để tránh lặp lại nội dung.\n" +
                "          ${features!}\n" +
                "          ${tag!}";

        List<ChatMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatMessage(ChatRole.USER, message));
        var chatOption = new ChatCompletionsOptions(chatMessages);
        return client.getChatCompletionsStream(azureOpenAIServiceConfigs.getDevelopmentName(), chatOption);
    }
}
