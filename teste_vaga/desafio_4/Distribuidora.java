public class Distribuidora {
    public static void main(String[] args) {
        // Faturamento mensal por estado
        double[] faturamento = {
            67836.43, // SP
            36678.66, // RJ
            29229.88, // MG
            27165.48, // ES
            19849.53  // Outros
        };
        
        // Nomes dos estados
        String[] estados = {"SP", "RJ", "MG", "ES", "Outros"};
        
        // Cálculo do faturamento total
        double totalFaturamento = 0;
        for (double valor : faturamento) {
            totalFaturamento += valor;
        }
        
        // Cálculo e exibição do percentual de cada estado
        System.out.printf("%-10s | %-10s | %-10s%n", "Estado", "Faturamento", "Percentual");
        System.out.println("---------------------------------------");
        for (int i = 0; i < faturamento.length; i++) {
            double percentual = (faturamento[i] / totalFaturamento) * 100;
            System.out.printf("%-10s | R$%-9.2f | %.2f%%%n", estados[i], faturamento[i], percentual);
        }
    }
}