package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class BoardImgFileRenamePolicy  implements FileRenamePolicy{

	@Override
	public File rename(File originFile) { //originFile: 원본파일
		long currentTime= System.currentTimeMillis();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddHHmmss"); //년도/월/일/시/분/초 형태로 currentTime의 형식을 바꿈.
		
		
		int randNum= (int)(Math.random()*100000);
		
		String name= originFile.getName(); //name: 원본파일 파일이름
		String ext=null;
		int dot=name.lastIndexOf(".");
		if(dot!=-1) {
			ext=name.substring(dot);
		}else {
			ext="";
		}
		
		// java.util.Date 를 이용.
		String fileName= "BOARD_"+sdf.format(new Date(currentTime))+randNum+ext;
		File newFile= new File(originFile.getParent(), fileName);
		return newFile;
	}
	
	

}
