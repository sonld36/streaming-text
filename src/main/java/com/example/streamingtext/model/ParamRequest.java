package com.example.streamingtext.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamRequest {
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_type")
    private String productType;
    private String features;
    private String tags;

}
