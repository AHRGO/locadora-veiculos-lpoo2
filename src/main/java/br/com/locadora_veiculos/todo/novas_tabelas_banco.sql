CREATE TABLE veiculo (
    id_veiculo INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(20) NOT NULL, -- usar apenas uma coluna em vez de uma tabela inteiramente nova para isso
    marca VARCHAR(50) NOT NULL,
    estado VARCHAR(20) NOT NULL, 
    categoria VARCHAR(20) NOT NULL, 
    modelo VARCHAR(50) NOT NULL, -- vai salvar a mesma coisa, uma string, então dá pra manter o mesmo campo
    valor_compra DOUBLE NOT NULL,
    placa VARCHAR(8) UNIQUE NOT NULL,
    ano INT NOT NULL
);

CREATE TABLE locacao (
    id_locacao INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT UNIQUE, -- cada cliente só pode ter uma locação
    id_veiculo INT UNIQUE, -- cada veículo só pode estar em uma locação
    dias INT NOT NULL,
    valor DOUBLE NOT NULL,
    data_locacao DATE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_veiculo) REFERENCES veiculo(id_veiculo)
);