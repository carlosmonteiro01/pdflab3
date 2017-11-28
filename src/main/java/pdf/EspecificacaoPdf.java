package pdf;


public class EspecificacaoPdf {
	
	private String autor;
	private String tema;
	private String data;
	
	
	public EspecificacaoPdf(String autor, String tema, String data) {
		this.autor = autor;
		this.tema = tema;
		this.data = data;
	}


	public String getAutor() {
		return autor;
	}
	

	public String getTema() {
		return tema;
	}

	public String getData() {
		return data;
	}


	public boolean comparar(EspecificacaoPdf esp){
		if(autor.equals(esp.autor) && tema.equals(esp.tema) && data.equals(esp.data)){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean compararPorAutor(String aut){
		if(autor.equals(aut)){
			return true;
		} else {
			return false;
		}
	}

}