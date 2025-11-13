package br.com.locadora_veiculos.model.veiculo.enums;

public enum ModeloAutomovel {
    GOL("Gol"),
    CELTA("Celta"),
    PALIO("Palio");

    private String nomeExibicao;

    ModeloAutomovel(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    @Override
    public String toString() {
        return nomeExibicao;
    }

    public static ModeloAutomovel fromString(String nome) {
        for(ModeloAutomovel modelo: ModeloAutomovel.values()) {
            if(modelo.name().equalsIgnoreCase(nome)) return modelo;
        }

        throw new IllegalArgumentException(String.format("O modelo de automóvel %s não existe!", nome));
    }
}
