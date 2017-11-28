package pdf;

import static spark.Spark.*;

public class MainServer {
	
	final static ModelPdf model = new ModelPdf();
	final static ModelUsuario modelUsuario = new ModelUsuario();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 1235;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarPdfs();
		inicializarUsuarios();

		Controller controller = new Controller(model, modelUsuario);

		controller.login();
		controller.buscarPdf();
		controller.buscarPdfPorAutor();
		
    }
    
    public static void inicializarPdfs(){
 
//    	model.addPdf(new Pdf("Livro 1", new EspecificacaoPdf("Carlos", "Esporte", "Julho")));
//    	model.addPdf(new Pdf("Livro 1", new EspecificacaoPdf("Carlos", "Moda", "Setembro")));
//    	model.addPdf(new Pdf("Livro 1", new EspecificacaoPdf("Carlos", "Tecnologia", "Setembro")));
//    	model.addPdf(new Pdf("Livro 2", new EspecificacaoPdf("Carlos", "Tecnologia", "Outubro")));
//    	model.addPdf(new Pdf("Livro 1", new EspecificacaoPdf("João Victor", "Esporte", "Julho")));
//    	model.addPdf(new Pdf("Livro 3", new EspecificacaoPdf("João Victor", "Esporte", "Outubro")));
//    	model.addPdf(new Pdf("Livro 4", new EspecificacaoPdf("João Victor", "Culinária", "Agosto")));
//    	model.addPdf(new Pdf("Livro 5", new EspecificacaoPdf("João Victor", "Tecnologia", "Outubro")));
    }
    public static void inicializarUsuarios(){
//    	modelUsuario.addUsuario(new Usuario("carlos", "Carlos", "1234"));
//    	modelUsuario.addUsuario(new Usuario("joao", "João", "1234"));
	}
}
