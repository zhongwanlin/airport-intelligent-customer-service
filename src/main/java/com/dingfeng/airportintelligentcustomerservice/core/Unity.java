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
     * 
     * @param file 文件路径+文件名称
     * 
     * @param conent 要生成的文件内容
     */
    public static void writeFile(String path, String fileName, String conent) throws Exception {

        BufferedWriter bufferedWriter = null;
        try {

            File filePath = new File(path);
            if (!filePath.exists())// 判断文件是否存在，若不存在则新建
            {
                filePath.mkdirs();
            }

            File file = new File(fileName);
            if (!file.exists())// 判断文件是否存在，若不存在则新建
            {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);// 实例化FileOutputStream
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");// 将字符流转换为字节流
            bufferedWriter = new BufferedWriter(outputStreamWriter);// 创建字符缓冲输出流对象
            bufferedWriter.write(conent);// 将格式化的jsonarray字符串写入文件
            bufferedWriter.flush();// 清空缓冲区，强制输出数据
            bufferedWriter.close();// 关闭输出流
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }
    }

}
