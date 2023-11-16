import java.util.ArrayList;
import java.util.List;

// Classe que representa uma ficha de academia para um cliente específico
public class FichaAcademia {
    // Nome do cliente associado à ficha
    private String nomeCliente;
    
    // Listas para armazenar os exercícios, séries e repetições da ficha
    private List<String> exercicios;
    private List<Integer> series;
    private List<Integer> repeticoes;

    // Construtor que inicializa o nome do cliente e as listas de exercícios, séries e repetições
    public FichaAcademia(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        exercicios = new ArrayList<>();
        series = new ArrayList<>();
        repeticoes = new ArrayList<>();
    }

    // Método para obter o nome do cliente associado à ficha
    public String getNomeCliente() {
        return nomeCliente;
    }

    // Método para adicionar um exercício à ficha com informações de série e repetição
    public void adicionarExercicio(String exercicio, int serie, int repeticao) {
        exercicios.add(exercicio);
        series.add(serie);
        repeticoes.add(repeticao);
    }

    // Método para obter a lista de exercícios da ficha
    public List<String> getExercicios() {
        return exercicios;
    }

    // Método para obter a lista de séries da ficha
    public List<Integer> getSeries() {
        return series;
    }

    // Método para obter a lista de repetições da ficha
    public List<Integer> getRepeticoes() {
        return repeticoes;
    }
}
