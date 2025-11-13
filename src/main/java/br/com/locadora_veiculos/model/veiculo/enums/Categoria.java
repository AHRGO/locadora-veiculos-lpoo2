package br.com.locadora_veiculos.model.veiculo.enums;

public enum Categoria {
    POPULAR("Popular"),
    INTERMEDIARIO("Intermediário"),
    LUXO("Luxo");

    private final String nomeExibicao;

    Categoria(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    @Override
    public String toString() {
        return nomeExibicao;
    }

    public static Categoria fromString(String nome) {
        for(Categoria categoria: Categoria.values()) {
            if (categoria.name().equalsIgnoreCase(nome)) {
                return categoria;
            }
        }

        throw new IllegalArgumentException(String.format("A categoria %s não foi encontrada!", nome));
    }
}
