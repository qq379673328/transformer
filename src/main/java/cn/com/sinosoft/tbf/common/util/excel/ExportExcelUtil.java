/**
 *
 *
 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
 * @date 2015-5-19
 */
package cn.com.sinosoft.tbf.common.util.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

/**
 * excel导出工具类
 *
 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
 * @since 2015-5-19
 */
@Component
public class ExportExcelUtil {

	/**
	 * 在输出流中创建excel
	 *
	 *
	 * @param items
	 *            数据项列表
	 * @param fieldDescs
	 *            表头行 <br>
	 *            String[][][] fieldDescs = new String[][][]{ {{"我是标题", "5",
	 *            "1"}}, {{"1行1列", "2", "1"},{"1行2列"},{"1行3列"},{"1行4列"}},
	 *            {{"2行1列"},{"1行2列"},{"2行3列", "2", "1"},{"2行4列"}} };
	 * @param fields
	 *            数据项中key列表
	 * @param outputStream
	 *            输出流
	 * @param type
	 *            0-2003,1-2007
	 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
	 * @throws IOException io异常
	 */
	public void generateExcel2Stream(List<Map<String, Object>> items, String[][][] fieldDescs, String[] fields,
			OutputStream outputStream, int type) throws IOException {

		Workbook wb;
		if (type == 0) {// 2003
			wb = new HSSFWorkbook();
		} else if (type == 1) {// 2007
			wb = new XSSFWorkbook();
		} else {// 2003-默认
			wb = new HSSFWorkbook();
		}
		Sheet sheet = wb.createSheet();
		List<Integer[]> mergeCells = new ArrayList<Integer[]>();
		Map<String, Object> mergeFlag = new HashMap<String, Object>();
		int colMax = 0;
		// 单元格样式
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBottomBorderColor(HSSFFont.COLOR_NORMAL);
		cellStyle.setTopBorderColor(HSSFFont.COLOR_NORMAL);
		cellStyle.setLeftBorderColor(HSSFFont.COLOR_NORMAL);
		cellStyle.setRightBorderColor(HSSFFont.COLOR_NORMAL);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		cellStyle.setWrapText(true);
		int rowIdx = 0;
		int cellIdx = 0;
		// 生成表头
		if (fieldDescs != null) {
			for (String[][] fieldDesc : fieldDescs) {
				Row row = sheet.createRow(rowIdx);
				rowIdx++;
				cellIdx = 0;
				for (String[] f : fieldDesc) {
					int len = f.length;
					String desc = len == 0 ? "" : f[0];
					Cell cell = row.createCell(cellIdx);
					cell.setCellValue(desc);
					cell.setCellStyle(cellStyle);

					int cols = 1;
					int rows = 1;
					if (len == 2) {
						cols = Integer.valueOf(f[1]);
					}
					if (len == 3) {
						cols = Integer.valueOf(f[1]);
						rows = Integer.valueOf(f[2]);
					}
					if (len == 4) {
						cols = Integer.valueOf(f[1]);
						rows = Integer.valueOf(f[2]);
						CellStyle cellStyle1 = wb.createCellStyle();
						cellStyle1.setBorderBottom(BorderStyle.THIN);
						cellStyle1.setBorderTop(BorderStyle.THIN);
						cellStyle1.setBorderLeft(BorderStyle.THIN);
						cellStyle1.setBorderRight(BorderStyle.THIN);
						cellStyle1.setBorderRight(BorderStyle.THIN);
						cellStyle1.setBottomBorderColor(HSSFFont.COLOR_NORMAL);
						cellStyle1.setTopBorderColor(HSSFFont.COLOR_NORMAL);
						cellStyle1.setLeftBorderColor(HSSFFont.COLOR_NORMAL);
						cellStyle1.setRightBorderColor(HSSFFont.COLOR_NORMAL);
						cellStyle1.setAlignment(HorizontalAlignment.CENTER);
						cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
						cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
						cellStyle1.setFillForegroundColor(Short.valueOf(f[3]));
						cell.setCellStyle(cellStyle1);
					}
					// 处理合并表头
					int beginRow = rowIdx - 1;
					int endRow = rowIdx - 1 + rows - 1;
					int beginCol = cellIdx;
					int endCol = cellIdx + cols - 1;
					if (endRow != beginRow || endCol != beginCol) {
						mergeCells.add(new Integer[]{beginRow, endRow, beginCol, endCol});
					}
					for (int m = beginRow; m <= endRow; m++) {
						for (int n = beginCol; n <= endCol; n++) {
							mergeFlag.put("" + m + "," + n, true);
						}
					}
					cellIdx = cellIdx + cols;
				}
			}
		}
		// 生成数据行
		for (Map<String, Object> item : items) {
			Row row = sheet.createRow(rowIdx);
			rowIdx++;
			cellIdx = 0;
			for (String field : fields) {
				Cell cell = row.createCell(cellIdx);
				Object obj = item.get(field);
				if (obj == null) {
					cell.setCellValue("");
				} else {
					cell.setCellValue(String.valueOf(obj));
				}
				cell.setCellStyle(cellStyle);
				cellIdx++;
				colMax = cellIdx > colMax ? cellIdx : colMax;
			}
		}
		// 合并单元格
		for (Integer[] oneMerge : mergeCells) {
			CellRangeAddress address = new CellRangeAddress(oneMerge[0], oneMerge[1], oneMerge[2], oneMerge[3]);
			sheet.addMergedRegion(address);
			RegionUtil.setBorderBottom(BorderStyle.THIN, address, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, address, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, address, sheet);
			RegionUtil.setBorderTop(BorderStyle.THIN, address, sheet);
		}
		// 调整列宽
		for (int i = 0; i < colMax; i++) {
			sheet.autoSizeColumn((short) i, true);
			sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 5 * 256);
		}

		wb.write(outputStream);
		wb.close();
	}

	/**
	 * 导出excel-2003
	 *
	 * @param items 数据项
	 * @param fieldDescs 字段描述
	 * @param fields 字段
	 * @param response 输出
	 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
	 */
	public void generateExcel2Web2003(List<Map<String, Object>> items, String[][][] fieldDescs, String[] fields,
			String title, HttpServletResponse response) {
		generateExcel2Web(items, fieldDescs, fields, title, response, 0);
	}

	/**
	 * 导出excel-2007
	 *
	 * @param items 数据项
	 * @param fieldDescs 字段描述
	 * @param fields 字段列表
	 * @param title 标题
	 * @param response response
	 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
	 */
	public void generateExcel2Web2007(List<Map<String, Object>> items, String[][][] fieldDescs, String[] fields,
			String title, HttpServletResponse response) {
		generateExcel2Web(items, fieldDescs, fields, title, response, 1);
	}

	/**
	 * 导出excel-2003
	 *
	 *
	 * @param items
	 * @param fieldDescs
	 * @param fields
	 * @param title
	 * @param response
	 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
	 */
	public void generateExcel2Web(List<Map<String, Object>> items, String[][][] fieldDescs, String[] fields,
			String title, HttpServletResponse response) {
		generateExcel2Web(items, fieldDescs, fields, title, response, 0);
	}

	/**
	 * 导出excel
	 *
	 *
	 * @param items
	 * @param fieldDescs
	 * @param fields
	 * @param title
	 * @param response
	 * @param type
	 *            0-2003，1-2007
	 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
	 */
	private void generateExcel2Web(List<Map<String, Object>> items, String[][][] fieldDescs, String[] fields,
			String title, HttpServletResponse response, int type) {
		try {
			if (title == null || title.trim().equals("")) {
				title = "导出";
			}
			OutputStream outputStream = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");
			title = URLEncoder.encode(title, "GB2312");
			title = URLDecoder.decode(title, "ISO8859_1");
			String subFix = "";
			if (type == 0) {// 2003
				subFix += ".xls";
			} else {// 2007
				subFix += ".xlsx";
			}
			response.setHeader("Content-disposition", "attachment;filename=" + title + subFix);
			generateExcel2Stream(items, fieldDescs, fields, outputStream, type);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
