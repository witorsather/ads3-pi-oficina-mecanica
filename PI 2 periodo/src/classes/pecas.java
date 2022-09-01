package classes;
public class pecas {
    private String descricao;
    private int codigo;
    private double valorUnitario;
    private int quantidadeEmEstoque;
    private int quantidadeEmRerserva;
    private int estoqueMinimo;
    
    public pecas () { 
    }
    public pecas (String descricao, int codigo, double valorUnitario, int quantidadeEmEstoque, int quantidadeEmReserva, int estoqueMinimo) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.valorUnitario = valorUnitario;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.quantidadeEmRerserva = quantidadeEmReserva;
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getQuantidadeEmRerserva() {
        return quantidadeEmRerserva;
    }

    public void setQuantidadeEmRerserva(int quantidadeEmRerserva) {
        this.quantidadeEmRerserva = quantidadeEmRerserva;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo)throws Exception {
        if (codigo <= 0) {
            throw new Exception ("O Código deve ser maior que 0");
        }
        this.codigo = codigo;
    }
    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    @Override
    public String toString () {
        return descricao + ";" + codigo + ";" + valorUnitario + ";" + quantidadeEmEstoque + ";" + quantidadeEmRerserva + ";" + estoqueMinimo;
    }
}