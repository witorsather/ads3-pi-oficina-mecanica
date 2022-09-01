package classes;

public class marca {

    private String descricao;
    private String logo;

    public marca() {
    }
    public marca(String descricao, String logo) {
        this.descricao = descricao;
        this.logo = logo;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return descricao + "," + logo;
    }

}
