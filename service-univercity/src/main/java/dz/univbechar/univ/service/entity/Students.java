package dz.univbechar.univ.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String ID;
	private String name;
	private String famlyname;
	private String sp;
	private String univ;
	private String promotion;
	private String lavel;
	
	
	
	public Students() {
		
	}
	public Students(String name, String famlyname, String sp, String univ, String promotion, String lavel) {
		
		this.name = name;
		this.famlyname = famlyname;
		this.sp = sp;
		this.univ = univ;
		this.promotion = promotion;
		this.lavel = lavel;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamlyname() {
		return famlyname;
	}
	public void setFamlyname(String famlyname) {
		this.famlyname = famlyname;
	}
	public String getSp() {
		return sp;
	}
	public void setSp(String sp) {
		this.sp = sp;
	}
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getLavel() {
		return lavel;
	}
	public void setLavel(String lavel) {
		this.lavel = lavel;
	}
	@Override
	public String toString() {
		return "Students [ID=" + ID + ", name=" + name + ", famlyname=" + famlyname + ", sp=" + sp + ", univ=" + univ
				+ ", promotion=" + promotion + ", lavel=" + lavel + "]";
	}
	

}
