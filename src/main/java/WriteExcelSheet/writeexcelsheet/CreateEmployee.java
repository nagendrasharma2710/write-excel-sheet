package WriteExcelSheet.writeexcelsheet;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateEmployee {
	public static void main(String []args) {
		try {
			Workbook workBook = new XSSFWorkbook();
			org.apache.poi.ss.usermodel.Sheet sh = workBook.createSheet("EmployeeDetails");
			String[] columnHeadings = {"EmployeeId","EmployeeName","EmployeeEmail","EmployeePhone","EmployeeDate"};
		    Font headerFont = workBook.createFont();
		    headerFont.setBold(true);
		    headerFont.setFontHeightInPoints((short) 12);
		    headerFont.setColor(IndexedColors.BLACK.index);
		    
		    CellStyle headerStyle = workBook.createCellStyle();
		    headerStyle.setFont(headerFont);
		    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		    Row headerRow = sh.createRow(0);
		    
		    for(int i=0; i<columnHeadings.length; i++) {
		    	Cell cell = headerRow.createCell(i);
		    	cell.setCellValue(columnHeadings[i]);
		    	cell.setCellStyle(headerStyle);
		    }
		    ArrayList<EmployeeDetails> arraylist = createData();
		    CreationHelper creationHelper = workBook.getCreationHelper();
		    CellStyle dateStyle = workBook.createCellStyle();
		    dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));
		    int rownum= 1;
		    for(EmployeeDetails empDetail : arraylist) {
		    Row row = sh.createRow(rownum++);
		    row.createCell(0).setCellValue(empDetail.getEmpId());
		    row.createCell(1).setCellValue(empDetail.getEmpName());
		    row.createCell(2).setCellValue(empDetail.getEmpEmail());
		    row.createCell(3).setCellValue(empDetail.getEmpPhone());
		    row.createCell(4).setCellValue(empDetail.getEmpJoinDate());
//		    Cell dateCell = row.createCell(4);
//		    dateCell.setCellValue(empDetail.empJoinDate);
//		    dateCell.setCellStyle(dateStyle);
		    }
		    for(int i=0; i<columnHeadings.length; i++) {
		    	sh.autoSizeColumn(i);
		    }
		    org.apache.poi.ss.usermodel.Sheet sh2 = workBook.createSheet("Second");
		    FileOutputStream fileOut = new FileOutputStream("C:\\Users\\praveen\\Documents\\client\\practice\\workspace\\write-excel-sheet\\write-excel-sheet\\employee.xlsx");
		    workBook.write(fileOut);
		    fileOut.close();
		    workBook.close();
		    System.out.println("Employee Details File Created Successfully !!!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
            private static ArrayList<EmployeeDetails> createData() throws ParseException {
            	ArrayList<EmployeeDetails> arraylist = new ArrayList();
            	arraylist.add(new EmployeeDetails(101,"John ","john123@gmail.com", 88796, new SimpleDateFormat("MM-dd-yyyy").parse("08-10-2021")));
            	arraylist.add(new EmployeeDetails(102,"David","david@gmail.com", 800096, new SimpleDateFormat("MM-dd-yyyy").parse("12-12-2021")));
            	arraylist.add(new EmployeeDetails(103,"Smith","smith@gmail.com", 332796, new SimpleDateFormat("MM-dd-yyyy").parse("04-07-2021")));
            	arraylist.add(new EmployeeDetails(104,"Renaldo","renaldo3@gmail.com", 119796, new SimpleDateFormat("MM-dd-yyyy").parse("06-04-2021")));
            	arraylist.add(new EmployeeDetails(105,"Trump","trump23@gmail.com", 55796, new SimpleDateFormat("MM-dd-yyyy").parse("02-11-2021")));
            	return arraylist;
            }
}
