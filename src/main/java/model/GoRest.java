package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class GoRest {

   private String name;
   private String gender;
   private String email;
   private String status;

}
