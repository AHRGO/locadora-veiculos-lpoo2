package br.com.locadora_veiculos.model.veiculo.enums;

public enum ModeloVan {
    KOMBI("Kombi"),
    SPRINTER("Sprinter");

    private String nomeExibicao;

    ModeloVan(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    @Override
    public String toString() {
        return nomeExibicao;
    }

    public static ModeloVan fromString(String nome) {
        for(ModeloVan van : ModeloVan.values()) {
            if(van.name().equalsIgnoreCase(nome)) return van;
        }

        throw new IllegalArgumentException(String.format("%s O modelo da van %s não existe!", nome));
    }


}
