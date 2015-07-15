package hr.foi.air.brioniinfo.db;

public class Linija {
	private long linija_id;
	private String opis;
	
	public Linija(){
		super();
	}
	
	public Linija(long linija_id, String opis){
		super();
		this.linija_id = linija_id;
		this.opis = opis;
	}
	
	public long getLinijaId(){
		return linija_id;
	}
	
	public String getOpis(){
		return opis;
	}
}
