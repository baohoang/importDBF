package vn.ansv.ebu.provisioning.importdbf;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private File fileUpload;
	private String[] fileUploadHeader;
	public String[] tuyensinh_bangdiemHeader = new String[] {};

	private Map<String, Object> session;
	
	
	public List<String> tblHeader;
	
	public String[] getTuyensinh_bangdiemHeader() {
		return tuyensinh_bangdiemHeader;
	}

	public void setTuyensinh_bangdiemHeader(String[] tuyensinh_bangdiemHeader) {
		this.tuyensinh_bangdiemHeader = tuyensinh_bangdiemHeader;
	}

	public String[] getFileUploadHeader() {
		return fileUploadHeader;
	}

	public void setFileUploadHeader(String[] fileUploadHeader) {
		this.fileUploadHeader = fileUploadHeader;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String display(){
		try{
		CustomDbfReader dbf = new CustomDbfReader(fileUpload);
		session.put("numberOfColumns", dbf.getNumOfColumns());
		session.put("columnNames", dbf.getColumnNames());
		session.put("columnTypes", dbf.getColumnTypes());
		session.put("numberOfRows", dbf.getNumOfRows());
		session.put("rowData", dbf.getRowData());
		return SUCCESS;
		}catch(Exception e){
		}
		return ERROR;
	}
	
	public String updateDataBase() throws Exception{
		
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
}