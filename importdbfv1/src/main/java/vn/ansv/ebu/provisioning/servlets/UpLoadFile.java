package vn.ansv.ebu.provisioning.servlets;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ansv.ebu.provisioning.importdbf.CustomDbfReader;

/**
 * Servlet implementation class UpLoadFile
 */
public class UpLoadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpLoadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String saveFile = "";
		String contentType = request.getContentType();
		if ((contentType != null)
				&& (contentType.indexOf("multipart/form-data") >= 0)) {
			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			String file = new String(dataBytes);
			saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
					saveFile.indexOf("\""));
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,
					contentType.length());
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			saveFile = "D:/data/" + saveFile;
			File ff = new File(saveFile);
			FileOutputStream fileOut = new FileOutputStream(ff);
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
//			CustomDbfReader dbf = new CustomDbfReader(ff);
//			// ff.delete();
			HttpSession session = request.getSession();
//			session.setAttribute("numberOfColumns", dbf.getNumOfColumns());
//			session.setAttribute("columnNames", dbf.getColumnNames());
//			session.setAttribute("columnTypes", dbf.getColumnTypes());
//			session.setAttribute("numberOfRows", dbf.getNumOfRows());
//			session.setAttribute("rowData", dbf.getRowData().get(0)[0]);
			
			/*Du lieu thu nghiem*/
			List<String> columnNames = new ArrayList<String>();
			List<String> columnTypes = new ArrayList<String>();
			List<Object[]> rowData= new ArrayList<Object[]>();
			
			columnNames.add("Ho");
			columnNames.add("Ten Dem");
			columnNames.add("Ten");
			columnNames.add("Que quan");
			columnNames.add("Khoi thi");
			columnNames.add("Diem 1");
			columnNames.add("Diem 2");
			columnNames.add("Diem 3");
			
			rowData.add(new String[]{"Vu", "Van", "Huy", "Nam Dinh", "A", "8.5", "8", "8.5"});
			
			//session.setAttribute("columnNames", columnTypes);
			session.putValue("rowData", rowData);
			session.putValue("columnNames", columnNames);
			
			//send redirect view_dbf.jsp
			response.sendRedirect("view_dbf.jsp");
		}
	}

}
