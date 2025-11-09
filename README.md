

Uma empresa que loca veículos (automóveis, vans e motos) resolveu criar um sistema 
para **gerenciar o ciclo de vida de seus veículos (da compra, passando pelas locações, até a venda do veículo).** 
O novo sistema precisa 
- ser em Java 
- com interface SWING 
- seguindo o paradigma orientado a objetos.

# Requisitos
1. Uma tela para manter `(incluir, atualizar, excluir e listar)` os clientes da empresa (Nome, sobre nome, RG, CPF,
   Endereço)
   - a. Nesta tela deve ser possível **listar** todos os clientes (Use AbstractTableModel)
   - b. Deve ser possível **atualizar** os dados de um cliente.
   - c. Deve ser possível **excluir** um cliente que **não possua veículos locados**. 
        Se houver uma tentativa de exclusão de clientes com veículos locados 
         uma mensagem do sistema deve informar ao usuário que o cliente não pode ser excluído.
   - d. Deve ser possível **listar todos os clientes em uma tabela** (Utilize AbstractTableModel)
2. Uma tela para incluir os veículos novos quando são comprados
   - a. Deve-se utilizar herança para definir os veículos. Uma classe Veículo (abstrata) deve ser criada. A classe
     Veículo deve implementar a seguinte interface:
   ```java
     public interface VeiculoI {
         //Muda estado para LOCADO. Cria uma instância de Locacao e armazena no atributo locacao. Chama o método getValorDiariaLocacao para calcular o valor da locação.
         public void locar(int dias, Calendar data, Cliente cliente);
         //Muda estado para VENDIDO e não pode mais ser alugado
         public void vender();
         //Muda estado para DISPONIVEL
         public void devolver();
         public Estado getEstado();
         public Marca getMarca();
         public Categoria getCategoria();
         public Locacao getLocacao();
         public String getPlaca();
         public int getAno();
         // Método que calcula um valor para venda. Utilizar o seguinte cálculo:
         // valorParaVenda = valorDeCompra – idadeVeiculoEmAnos*0,15*valorDeCompra
         // Se o resultado for menor do que 10% do valorDeCompra ou negative, então
         // varlorParaVenda = valorDeCompra*0,1
         public double getValorParaVenda();
         //Método que será abstrato na classe Veiculo
         public double getValorDiariaLocacao();
     }
   ```
   - b. A classe veículo deve ter os seguintes atributos:
     - i. Criar um construtor com todos os atributos como parâmetro.
     - ii. marca – Crie uma classe de nome Marca e do tipo enum para definir este atributo. Pode assumir
       os seguintes valores (VW, GM, Fiat, Honda, Mercedes, etc)
     - iii. estado - - Crie uma classe de nome Estado e do tipo enum para definir este atributo. Pode assumir
       os seguintes valores (NOVO, LOCADO, DISPONIVEL, VENDIDO)
     - iv. locacao – Crie uma classe Locacao especificada no item 3. Este objeto será nulo quando o estado
       do veículo for diferente de LOCADO. O objeto será instanciado somente quando o veiculo for
       alugado (método alugar) e será atribuído nulo quando o veículo for devolvido (método
       devolverAluguel).
     - v. categoria - Crie uma classe de nome Categoria e do tipo enum para definir este atributo. Pode
       assumir os seguintes valores (POPULAR, INTERMEDIARIO, LUXO). Este atributo írá definir o
       preço da diária de um aluguel.
     - vi. valorDeCompra – double que representa o valor de compra do veículo
     - vii. placa – String. String no formato XXX-0000, onde X é um alfabético de A a Z e 0 é um numério de
       0 a 9.
     - viii. ano – int. Inteiro representado o ano modelo do veículo.
     - ix. Não crie métodos de get e set para cada atributo. Crie somente os métodos que estão descritos na
       interface VeiculoI