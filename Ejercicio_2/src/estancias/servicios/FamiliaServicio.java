package estancias.servicios;

import estancias.entidades.Casa;
import estancias.entidades.Familia;
import estancias.persistencias.CasaDAO;
import estancias.persistencias.FamiliaDAO;

import java.util.List;

public class FamiliaServicio {
    private final FamiliaDAO DAO = new FamiliaDAO();
    private final List<Familia> familias = DAO.obtenerFamilias();

    public FamiliaServicio() throws Exception {
    }

    public void mostrarFamilias(){
        try {
            FamiliaDAO DAO = new FamiliaDAO();
            List<Familia> familias = DAO.obtenerFamilias();

            System.out.println("Tamaño de casas + " + familias.size());
            for (Familia familia: familias) {
                System.out.println(familia);
            }
        }catch (Exception e){
            System.out.println("Algo salio mal trayendo las familias");
        }
    }

    public void familiasConTresHijos() {
        try {
            System.out.println("FAMILIAS CON 3 O MAS HIJOS CON EDAD MAXIMA MENOR A 10:");
            for (Familia fam: familias) {
                    if(fam.getNum_hijos() >= 3 && fam.getEdad_maxima() < 10){
                        System.out.printf("Familia %s, id: %d con %d y edad maxima %d.\n", fam.getNombre(), fam.getId(), fam.getNum_hijos(), fam.getEdad_maxima());
                    }
            }

        }catch (Exception e){
            System.out.println("ERROR EN familiasConTresHijos");
        }
    }

    public void familiasConHotmail(){
        try {
            System.out.println("FAMILIAS CON HOTMAIL:");
            for (Familia fam: familias) {
                if(fam.getEmail().matches("^[a-zA-Z0-9._%+-]+@hotmail.+[a-zA-Z]{3}")){
                    System.out.printf("Familia %s, id: %d, email: %s\n", fam.getNombre(), fam.getId(), fam.getEmail());
                }
            }
        }catch (Exception e){
            System.out.println("ERROR EN familiasConHotmail");
        }
    }

}
