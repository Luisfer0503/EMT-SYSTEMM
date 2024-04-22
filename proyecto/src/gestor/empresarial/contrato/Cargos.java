package gestor.empresarial.contrato;

public enum Cargos {
    CONFIANZA("Empleado confianza"),
    SINDICALIZADO("Empledo sindicalizado"),
    TEMPORAL("Empleado temporal");

    private final String nombre;

    Cargos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
};
