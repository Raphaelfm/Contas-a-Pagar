

public class Credor {
    private String nome, observacao;
    private float valor;
    private String data_previsao;
    private int id;

    @Override
    public String toString() {
        return "Credor [data_previsao=" + data_previsao + ", nome=" + nome + ", observacao=" + observacao + ", valor="
                + valor + "]";
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getData_previsao() {
        return data_previsao;
    }
    public void setData_previsao(String data_previsao) {
        this.data_previsao = data_previsao;
    }



    
}
