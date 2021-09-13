package estancias.entidades;

public class Comentario {
    private int id;
    private String mensaje;
    private Casa casa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", mensaje='" + mensaje + '\'' + ", \ncasa=\n" + casa + '}';
    }
}
