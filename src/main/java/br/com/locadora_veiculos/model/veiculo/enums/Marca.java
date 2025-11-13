package br.com.locadora_veiculos.model.veiculo.enums;

public enum Marca {
    VOLKSWAGEN("Volkswagen"),
    GENERAL_MOTORS("General Motors"),
    FIAT("Fiat"),
    HONDA("Honda"),
    MERCEDES("Mercedes");

    private final String nomeExibicao;

    Marca(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public static Marca fromString(String nome) {
        for(Marca marca : Marca.values()) {
            if(marca.name().equalsIgnoreCase(nome)) {
                return marca;
            }

        }

        throw new IllegalArgumentException(String.format("A marca %s não foi encontrada!", nome));
    }

    @Override
    public String toString() {
        return nomeExibicao;
    }
}
