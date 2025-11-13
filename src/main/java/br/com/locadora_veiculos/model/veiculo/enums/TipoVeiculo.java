package br.com.locadora_veiculos.model.veiculo.enums;

public enum TipoVeiculo {
    AUTOMOVEL("Automóvel"),
    MOTOCICLETA("Motocicleta"),
    VAN("Van");

    private String nomeExibicao;

    TipoVeiculo(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    @Override
    public String toString() {
        return nomeExibicao;
    }

    public static TipoVeiculo fromString(String nome) {
        for(TipoVeiculo veiculo : TipoVeiculo.values()) {
            if(veiculo.name().equalsIgnoreCase(nome)) return veiculo;
        }

        throw new IllegalArgumentException(String.format("%s O tipo de veiculo %s não existe!", nome));
    }
}