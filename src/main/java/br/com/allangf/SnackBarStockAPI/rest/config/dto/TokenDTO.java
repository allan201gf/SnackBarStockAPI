package br.com.allangf.SnackBarStockAPI.rest.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    private String email;
    private String token;

}
