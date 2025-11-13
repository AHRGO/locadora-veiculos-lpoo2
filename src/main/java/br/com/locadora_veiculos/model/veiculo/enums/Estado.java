package br.com.locadora_veiculos.model.veiculo.enums;

public enum Estado {
    NOVO("Novo"),
    LOCADO("Locado"),
    DISPONIVEL("Disponível"),
    VENDIDO("Vendido");

    private final String nomeExibicao;

    Estado (String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public static Estado fromString(String nome) {
        for (Estado estado: Estado.values()) {
            if (estado.name().equalsIgnoreCase(nome)) {
                return estado;
            }
        }

        throw new IllegalArgumentException(String.format("O estado %s não foi encontrado!", nome));
    }


    @Override
    public String toString() {
        return nomeExibicao;
    }
}
