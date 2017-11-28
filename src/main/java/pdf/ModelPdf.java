package pdf;

import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import pdf.Pdf;


public class ModelPdf{
		ObjectContainer pdfs = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/pdfs.db4o");

//		private List<Pdf> pdfs = new LinkedList<Pdf>();
		//private List<Usuario> usuarios = new LinkedList<Usuario>();
		//private Administrador administradores = new Administrador();
		
		
		public void addPdf(Pdf pdf){
			pdfs.store(pdf);
			pdfs.commit();
		}
		
		//public void delPdf(Pdf pdf){
		//}

		
		public Pdf buscarTitulo(String titulo){
			Query query = pdfs.query();
			query.constrain(Pdf.class);
			ObjectSet<Pdf> allPdfs = query.execute();

			for(Pdf pdf:allPdfs){
				if(pdf.getTitulo().equals(titulo)) return pdf;
			}
			
			return null;
		}
		
		
		public List<Pdf> buscarEspecificacaoPdf(EspecificacaoPdf esp){
			List<Pdf> pdfsEncontrados = new LinkedList<Pdf>();

			Query query = pdfs.query();
			query.constrain(Pdf.class);
			ObjectSet<Pdf> allPdfs = query.execute();

			for(Pdf pdf:allPdfs){
				if(esp.comparar(pdf.getEspc())) pdfsEncontrados.add(pdf);
			}

			return pdfsEncontrados;
			
		}
		
		public List<Pdf> buscarAutorPdf(EspecificacaoPdf esp){
			List<Pdf> pdfsEncontrados = new LinkedList<Pdf>();

			Query query = pdfs.query();
			query.constrain(Pdf.class);
			ObjectSet<Pdf> allPdfs = query.execute();

			for(Pdf pdf:allPdfs){
				 if(esp.compararPorAutor(pdf.getEspc().getAutor())) pdfsEncontrados.add(pdf);
			}
			
			return pdfsEncontrados;
			
		}


		public ObjectContainer getPdfs(){
			return pdfs;
		}
}
