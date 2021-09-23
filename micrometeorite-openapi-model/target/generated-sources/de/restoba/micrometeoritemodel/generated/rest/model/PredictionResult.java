package de.restoba.micrometeoritemodel.generated.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PredictionResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-23T22:17:02.762499800+02:00[Europe/Berlin]")
public class PredictionResult   {
  @JsonProperty("micrometeoriteFindId")
  private BigDecimal micrometeoriteFindId = null;

  public PredictionResult micrometeoriteFindId(BigDecimal micrometeoriteFindId) {
    this.micrometeoriteFindId = micrometeoriteFindId;
    return this;
  }

  /**
   * Get micrometeoriteFindId
   * @return micrometeoriteFindId
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getMicrometeoriteFindId() {
    return micrometeoriteFindId;
  }

  public void setMicrometeoriteFindId(BigDecimal micrometeoriteFindId) {
    this.micrometeoriteFindId = micrometeoriteFindId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PredictionResult predictionResult = (PredictionResult) o;
    return Objects.equals(this.micrometeoriteFindId, predictionResult.micrometeoriteFindId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(micrometeoriteFindId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PredictionResult {\n");
    
    sb.append("    micrometeoriteFindId: ").append(toIndentedString(micrometeoriteFindId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
