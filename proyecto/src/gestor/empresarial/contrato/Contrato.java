package gestor.empresarial.contrato;

public class Contrato {
    private int id;
    private String noContrato;
    private String annio;
    private String horario;
    private String tipoCargo;

    public Contrato(int id, String noContrato, String annio, String horario, String tipoCargo) {
        this.id = id;
        this.noContrato = noContrato;
        this.annio = annio;
        this.horario = horario;

        /*tipoCargo = Cargos.CONFIANZA;
        tipoCargo = Cargos.SINDICALIZADO;
        tipoCargo = Cargos.TEMPORAL;*/

        this.tipoCargo = tipoCargo;
    }

    public Contrato() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoContrato() {
        return noContrato;
    }

    public void setNoContrato(String noContrato) {
        this.noContrato = noContrato;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

}
