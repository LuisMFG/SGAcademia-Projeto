import java.util.ArrayList;
import java.util.List;

public class FichaAcademia {
    private String nomeCliente;
    private List<String> exercicios;
    private List<Integer> series;
    private List<Integer> repeticoes;

    public FichaAcademia(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        exercicios = new ArrayList<>();
        series = new ArrayList<>();
        repeticoes = new ArrayList<>();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void adicionarExercicio(String exercicio, int serie, int repeticao) {
        exercicios.add(exercicio);
        series.add(serie);
        repeticoes.add(repeticao);
    }

    public List<String> getExercicios() {
        return exercicios;
    }

    public List<Integer> getSeries() {
        return series;
    }

    public List<Integer> getRepeticoes() {
        return repeticoes;
    }
}
