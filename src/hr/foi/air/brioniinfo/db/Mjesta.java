package hr.foi.air.brioniinfo.db;


public class Mjesta {
	//@JsonProperty("mjesto_id")
	private long mjesto_id;
	private String naziv;
	private long maps_latitude;
	private long maps_longitude;
	
	public Mjesta(){
		super();
	}
	
	public Mjesta(long mjesto_id, String naziv, long maps_latitude, long maps_longitude){
		super();
		this.mjesto_id = mjesto_id;
		this.naziv = naziv;
		this.maps_latitude = maps_latitude;
		this.maps_longitude = maps_longitude;
	}
	
	public long getMjestoId(){
		return mjesto_id;
	}
	
	public String getNaziv(){
		return naziv;
	}
	
	public long getMapsLatitude(){
		return maps_latitude;
	}
	
	public long getMapsLongitude(){
		return maps_longitude;
	}
}
