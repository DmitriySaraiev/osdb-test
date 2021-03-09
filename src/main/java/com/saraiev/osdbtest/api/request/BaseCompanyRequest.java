package com.saraiev.osdbtest.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BaseCompanyRequest {

    @NotEmpty
    @JsonProperty("title")
    private String title;

    @NotNull
    @JsonFormat(pattern="yyyy/MM/dd")
    @JsonProperty("founded")
    private Date founded;

}
