package pdf;

public class Pdf {

	private String titulo;
	//private String url;
	private EspecificacaoPdf espc;
	
	
	public Pdf(String titulo, EspecificacaoPdf espc){
		this.titulo = titulo;
		//this.url = url;
		this.espc = espc;
		
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public EspecificacaoPdf getEspc(){
		return espc;
	}
	
}