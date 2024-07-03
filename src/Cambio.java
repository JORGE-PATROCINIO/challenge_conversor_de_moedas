import java.util.Map;

public record Cambio(String base_code, Map<String,Double> conversion_rates) {
}
