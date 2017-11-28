package pdf;

import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import pdf.Pdf;
import pdf.Usuario;


public class ModelUsuario{
    ObjectContainer usuarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");

//		private List<Pdf> usuarios = new LinkedList<Pdf>();
    //private List<Usuario> usuarios = new LinkedList<Usuario>();
    //private Administrador administradores = new Administrador();


    public void addUsuario(Usuario usuario){
        usuarios.store(usuario);
        usuarios.commit();
    }

    //public void delPdf(Pdf usuario){
    //}

//    public Pdf buscarTitulo(String titulo){
//        Query query = pdfs.query();
//        query.constrain(Pdf.class);
//        ObjectSet<Pdf> allPdfs = query.execute();
//
//        for(Pdf pdf:allPdfs){
//            if(pdf.getTitulo().equals(titulo)) return pdf;
//        }
//
//        return null;
//    }
    public Usuario login(String login, String senha){
        Query query = usuarios.query();
        query.constrain(Usuario.class);
        ObjectSet<Usuario> allUsuarios = query.execute();

        for(Usuario usuario:allUsuarios){

            if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){

                return usuario;
            }

        }
        return null;
    }

    public ObjectContainer getUsuarios(){
        return usuarios;
    }
}
