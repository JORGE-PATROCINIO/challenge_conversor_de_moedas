import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/66f1a4476321d0bc255500a4/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Cambio cambio = gson.fromJson(response.body(), Cambio.class);
        Converter conv = new Converter();

        String menu = """
                Seja bem-vindo/a ao conversor de moedas \n
                ######################################\n
                1) Dólar =>> Peso argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real brasileiro
                4) Real brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Sair
                \nEscolha uma opção válida:\n
                ######################################\n
                """;
        //System.out.println(cambio.conversion_rates());
        //System.out.println(cambio.base_code());

        System.out.println(menu);

        int op = sc.nextInt();

        if(op < 1 || op > 7){
            System.out.println("Opção inválida!");
        }
        else if (op == 7){
            System.out.println("Programa encerrado !");
        }else {
            System.out.println("Digite o Valor que pretende converter: ");

            Double valor = sc.nextDouble();

            conv.moeda(op);

            double valorAtual = cambio.conversion_rates().get(conv.moeda);

            System.out.println("Valor convertido - > " + conv.conversao(op, valor, valorAtual));
        }

    }
}