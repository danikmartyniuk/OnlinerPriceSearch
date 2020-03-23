package utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OnlinerStats {
    @JsonProperty("Date")
    String date;
    @JsonProperty("COVID")
    int covid;
    @JsonProperty("USD")
    String usd;
    @JsonProperty("EUR")
    String eur;
    @JsonProperty("Estate")
    int estate;
    @JsonProperty("Auto")
    int auto;
    @JsonProperty("iPhone")
    int iphone;
    @JsonProperty("Samsung")
    int samsung;
    @JsonProperty("Xiaomi")
    int xiaomi;
}
