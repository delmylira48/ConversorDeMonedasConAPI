package com.delmylira48.challengeConversor.DTO;

import java.util.Map;

public record MonedaDTO(Map<String, Double> conversion_rates, String base_code) {
}
