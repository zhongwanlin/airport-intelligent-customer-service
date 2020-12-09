package com.dingfeng.airportintelligentcustomerservice.core;

import java.io.*;

public class Unity {
    // 读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

        // 读取json文件
        public static String readJsonFile(InputStream inputStream) {
            String jsonStr = "";
            try {
                Reader reader = new InputStreamReader(inputStream, "utf-8");
                int ch = 0;
                StringBuffer sb = new StringBuffer();
                while ((ch = reader.read()) != -1) {
                    sb.append((char) ch);
                }
                reader.close();
                jsonStr = sb.toString();
                return jsonStr;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /*
	 * 生成文件
	 * @param file 文件路径+文件名称
	 * @param conent 要生成的文件内容
	 */
	public static void writeFile(String file, String conent) {
		// Log4jBean.logger.info("开始以追加的形式写文件到：["+file+"]");
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
			out.write(conent);
			// Log4jBean.logger.info("写文件:["+file+"]完成");
		} catch (Exception e) {
			// Log4jBean.logger.error("写文件:["+file+"]异常，异常信息为:["+e.getMessage()+"]");
		} finally {
			// Log4jBean.logger.info("开始关闭输出流");
			try {
				out.close();
			} catch (IOException e) {
				// Log4jBean.logger.info("关闭输出流异常，异常信息为:["+e.getMessage()+"]");
			}
		}
	}

}
