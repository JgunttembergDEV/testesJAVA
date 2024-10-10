
   import com.google.gson.Gson;
   import com.google.gson.JsonObject;
   import com.google.gson.JsonParser;

   import java.io.FileReader;
   import java.io.IOException;
   import java.util.HashMap;
   import java.util.Map;

   public class Faturamento {

       public static void main(String[] args) {
           String caminhoArquivo = "faturamento.json"; // Substitua pelo caminho do seu arquivo JSON

           try {
               // Ler o arquivo JSON
               FileReader reader = new FileReader(caminhoArquivo);
               JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
               Map<String, Double> faturamento = new HashMap<>();

               // Carregar os dados de faturamento
               jsonObject.getAsJsonObject("faturamento").entrySet().forEach(entry -> {
                   faturamento.put(entry.getKey(), entry.getValue().getAsDouble());
               });

               calcularFaturamento(faturamento);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

       private static void calcularFaturamento(Map<String, Double> faturamento) {
           double menorValor = Double.MAX_VALUE;
           double maiorValor = Double.MIN_VALUE;
           double soma = 0.0;
           int diasComFaturamento = 0;

           // Calcular menor, maior e soma dos faturamentos
           for (double valor : faturamento.values()) {
               if (valor > 0) {
                   diasComFaturamento++;
                   soma += valor;

                   if (valor < menorValor) {
                       menorValor = valor;
                   }
                   if (valor > maiorValor) {
                       maiorValor = valor;
                   }
               }
           }

           // Calcular a média
           double mediaMensal = soma / diasComFaturamento;

           // Contar dias com faturamento superior à média
           int diasAcimaDaMedia = 0;
           for (double valor : faturamento.values()) {
               if (valor > mediaMensal) {
                   diasAcimaDaMedia++;
               }
           }

           // Resultados
           System.out.println("Menor valor de faturamento: " + menorValor);
           System.out.println("Maior valor de faturamento: " + maiorValor);
           System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
       }
   }
   