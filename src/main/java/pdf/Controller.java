package pdf;


import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private ModelPdf model;
	private ModelUsuario usuario;
	
	public Controller(ModelPdf model, ModelUsuario usuario){
		this.model = model;
		this.usuario = usuario;
	}
	public void login(){
		get("/login/:senha/:login", (req, res) -> {

			Usuario usuario =this.usuario.login(req.params(":login"), req.params(":senha"));
			if (usuario == null) return false;
			return new Gson().toJson(usuario);
		});
	}
	public void buscarPdf(){
		get("/pdf/:autor/:tema/:data", (req, res) -> {
		
			EspecificacaoPdf espec = new EspecificacaoPdf(req.params(":autor"), req.params(":tema"), req.params(":data"));	
			List<Pdf> pdfsEncontrados = model.buscarEspecificacaoPdf(espec);	
			return new Gson().toJson(pdfsEncontrados);
			
		});
	}
	
	public void buscarPdfPorAutor(){
		get("/pdf/:autor", (req, res) -> {
			EspecificacaoPdf espec = new EspecificacaoPdf(req.params(":autor"), null, null);	
			List<Pdf> pdfsEncontrados = model.buscarAutorPdf(espec);	
			return new Gson().toJson(pdfsEncontrados);
			
		});
	}

}
