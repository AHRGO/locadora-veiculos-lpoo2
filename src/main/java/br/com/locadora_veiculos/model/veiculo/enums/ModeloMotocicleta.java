package br.com.locadora_veiculos.model.veiculo.enums;

public enum ModeloMotocicleta {
    CG_125("CG 125"),
    CBR_500("CBR 500");

    private String nomeExibicao;

    ModeloMotocicleta(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    @Override
    public String toString() {
        return nomeExibicao;
    }

    public static ModeloMotocicleta fromString(String nome) {
        for(ModeloMotocicleta modelo : ModeloMotocicleta.values()) {
            if(modelo.name().equalsIgnoreCase(nome)) return modelo;
        }

        throw new IllegalArgumentException(String.format("O modelo de motocicleta %s não existe"));
    }
}
