package ar.ugd.colonia.util;
import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.service.VoluntarioService;
import ar.ugd.colonia.service.impl.VoluntarioServiceImpl;

public class VoluntarioSaveTest {
  public static void main(String[] args){
    VoluntarioService svc = new VoluntarioServiceImpl();
    Voluntario v = new Voluntario("Ana","secreta123","ana@mail.com","3764000000",
                                  "Mitre 123","ALTA","Colabora desde 2023");
    svc.registrar(v);
    System.out.println("Voluntario id=" + v.getIdUsuario());
    System.out.println("Total=" + svc.listar().size());
    HibernateUtil.shutdown();
  }
}
