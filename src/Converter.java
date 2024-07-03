
public class Converter {
    private Cambio cambio;
    private double valorConvertido;
    public String moeda;

    public String moeda(int op){
        if (op == 1 || op == 2){
            moeda = "ARS";
        }else if(op == 3 || op == 4){
            moeda = "BRL";
        }else if (op == 5 || op == 6) {
            moeda = "COP";
        }
        return moeda;
    }

    public  double conversao(int op, double valor,double valorAtual){
        if(op == 1 || op == 3 || op == 5){
            valorConvertido = valor * valorAtual;
        }else if(op == 2 || op == 4 || op == 6){
            valorConvertido = valor / valorAtual;
        }
        return valorConvertido;
    }
}

