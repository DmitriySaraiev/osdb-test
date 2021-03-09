package com.saraiev.osdbtest.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateCompanyRequest extends BaseCompanyRequest {

    @NotNull
    @JsonProperty("id")
    private Long id;

}
