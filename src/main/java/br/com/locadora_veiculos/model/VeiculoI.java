public interface VeiculoI {

    /**
     * @implNote
     * <p>Muda estado para LOCADO</p>
     * <p>Cria uma instância de Locacao e armazena no atributo locacao</p>
     * <p>Chama o método getValorDiariaLocacao para calcular o valor da locação</p>
     * <p></p>
    */
    public void locar(int dias, Calendar data, Cliente cliente);

    /**
     * @implNote
     * <p>Muda o estado para VENDIDO e não pode mais ser alugado</p>
     */
    public void vender();

    /**
     * @implNote
     * <p>Muda o estado para DISPONIVEL</p>
     */
    public void devolver();

    //? vai ser um enum isso?
    public Estado getEstado();

    public Marca getMarca();
    
    public Categoria getCategoria();

    public Locacao getLocacao();

    public String getPlaca();

    public int getAno();

    /**
     * @implNote
     * <p>Para calcular o valor para a venda, é utilizado o seguinte calculo: </p>
     * <p><code>valorParaVenda = valorDeCompra - idadeVeiculoEmAnos * 0.15 * valorDeCompra</code></p>
     * <p>Se o resultado for menor que 10% do valorDeCompra ou negativo, então, o cálculo aplicado será: </p>
     * <p><code>valorParaVenda = valorDeCompra * 0.1</code></p>
     */
    public double getValorParaVenda();

    /**
     * Esse método será abstrato na classe veículo
     */
    public double getValorDiariaLocacao();
}