

//TODO: VALIDAR IMPLEMENTAÇÃO DA CLASSE
public class VeiculoTableModel extends AbstractTableModel {
    private String[] colunas = new String[] {"col1", "col2", "col3"}; //...
    private List<Veiculo> linhas = new ArrayList();

    
    public VeiculoTableModel() {};

    public VeiculoTableModel(List<Veiculo> veiculos) {this.linhas = veiculos;}

    @Override
    public int getRowCount() {
        return this.linhas.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    //TODO: VALIDAR O TIPO DO VEICULO
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = this.linhas.get(rowIndex);
        return switch(columnIndex) {
            case 0 -> veiculo.getId();
            // case 1 -> veiculo.getTipo(); => TODO: VALIDAR COMO VAI PEGAR O TIPO DO VEÍCULO
            case 1 -> veiculo.getMarca().name();
            case 2 -> veiculo.getEstado().name();
            case 3 -> veiculo.getCategoria().name();
            case 4 -> veiculo.getModelo().name();
            case 5 -> veiculo.getValorDaCompra();
            case 6 -> veiculo.getPlaca();
            case 7 -> veiculo.getAno();
            default -> null;
        };
    }


        public void adicionaVeiculo(Veiculo veiculo) {
        this.linhas.add(veiculo);
        this.fireTableRowsInserted(linhas.size()-1, linhas.size()-1);
    }

    public void setListaVeiculo(List<Veiculo> veiculos) {
        this.linhas = veiculos;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int primeiraLinha = 0;
        int ultimaLinha = linhas.size()-1;


        if(ultimaLinha < 0) ultimaLinha = 0;

        this.linhas = new ArrayList<>();
        this.fireTableRowsDeleted(primeiraLinha, ultimaLinha);
    }

    public Veiculo getVeiculo(int linhaIndex) {
        return linhas.get(linhaIndex);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        int indexOndeEstavaVeiculo = this.linhas.indexOf(veiculo);
        boolean veiculoFoiRemovido = this.linhas.remove(veiculo);

        this.fireTableRowsDeleted(indexOndeEstavaVeiculo, indexOndeEstavaVeiculo);
        return veiculoFoiRemovido;
    }

    public void removeMultiplosVeiculos(List<Veiculo> veiculos) {
        veiculos.forEach(this::removeVeiculo);
    }

}