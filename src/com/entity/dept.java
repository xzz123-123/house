package com.entity;

public class dept {
	private Integer DEPTNO;
	private String DNAME;
	private String LOC;
	public Integer getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(Integer dEPTNO) {
		DEPTNO = dEPTNO;
	}
	public String getDNAME() {
		return DNAME;
	}
	public void setDNAME(String dNAME) {
		DNAME = dNAME;
	}
	public String getLOC() {
		return LOC;
	}
	public void setLOC(String lOC) {
		LOC = lOC;
	}
	public dept() {
	}
	public dept(Integer dEPTNO, String dNAME, String lOC) {
		DEPTNO = dEPTNO;
		DNAME = dNAME;
		LOC = lOC;
	}
	public String toString() {
		return "dept [DEPTNO=" + DEPTNO + ", DNAME=" + DNAME + ", LOC=" + LOC
				+ "]";
	}
	
}
