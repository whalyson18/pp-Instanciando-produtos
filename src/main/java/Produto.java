import lombok.NonNull;

import java.time.LocalDate;

public class Produto {
    private long id;
    private String codigoEan;
    private String descricao;
    private String marca;
    private String modelo;
    private double preco;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private int estoque = 0;
    private String categoria;
    private String urlFoto;

    Produto(long id, String codigoEan, String descricao, String marca, String modelo, double preco, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao, int estoque, String categoria, String urlFoto) {
        this.setId(id);
        this.codigoEan = codigoEan;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.estoque = estoque;
        this.categoria = categoria;
        this.urlFoto = urlFoto;
    }

    public long getId() {
        return id;
    }

    public final void setId(@NonNull long id) {
        this.id = id;
    }

    public String getCodigoEan() {
        return codigoEan;
    }

    public void setCodigoEan(String codigoEan) {
        if (codigoEan == null || codigoEan.isEmpty())
            throw new IllegalArgumentException("Caompo codigoEan não pode ser nulo.");
        this.codigoEan = codigoEan;
    }

    public String getDescricao() {
        return descricao;
    }

    public final void setDescricao(@NonNull String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(@NonNull String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        if (marca == null || marca.isEmpty())
            throw new IllegalArgumentException("Não pode ser informado um modelo se não for informada a marca.");

        if (modelo == null || modelo.isEmpty())
            throw new IllegalArgumentException("Campo modelo não pode ser nulo.");
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public final void setPreco(@NonNull double preco) {
        if (preco > 0)
            throw new IllegalArgumentException("O preço deve ser maior que zero.");

        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public final void setDataCadastro(@NonNull LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        if (dataUltimaAtualizacao.isAfter(dataCadastro))
            throw new IllegalArgumentException("A data da última atualização não pode ser anterior a data de cadastro.");

        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque > 0)
            throw new IllegalArgumentException("Não pode ser atribuído valor negativo.");

        this.estoque = estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NonNull String categoria) {
        this.categoria = categoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        if (urlFoto == null)
            throw new IllegalArgumentException("Campo urlFoto não pode ser nulo.");
        this.urlFoto = urlFoto;
    }

}
