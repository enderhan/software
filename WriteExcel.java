package GroupName_zero_Segmentation.chinese_segmentation;
import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class WriteExcel {
	
	public void writeExcel(String path) {
		WritableWorkbook wb;
		try {
			wb = Workbook.createWorkbook(new File(path));
			WritableSheet ws = wb.createSheet("sheet1", 0);
			for(int i=0;i<5;i++){
				Number labelN = new Number(1, i+1, i);
				//第一个是第几列，列数从0开始，1,表示第二列,第二个是第几行，行数从0开始,第三个是想显示的东西
				ws.addCell(labelN);
			}
			wb.write();
			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}