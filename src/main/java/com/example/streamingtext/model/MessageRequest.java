package com.example.streamingtext.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private String content;

    @JsonProperty("prompt_id")
    private Integer promptId;

    @JsonProperty("system_template_id")
    private Integer systemTemplateId;

    private ParamRequest params;

    @JsonProperty("voice_id")
    private String voiceId;

    @JsonProperty("other_requirement")
    private String otherRequirement;

    @JsonProperty("content_type")
    private String contentType;

    @JsonProperty("content_format")
    private String contentFormat;

    @JsonProperty("reference_document_type")
    private String referenceDocumentType;
    @JsonProperty("reference_document_id")
    private String referenceDocumentId;
    @JsonProperty("reference_document_name")
    private String referenceDocumentName;
}
