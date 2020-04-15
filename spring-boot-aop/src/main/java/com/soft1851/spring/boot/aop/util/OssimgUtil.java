package com.soft1851.spring.boot.aop.util;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * @author wl
 * @ClassNameOssimgUtil
 * @Description TODO
 * @Date 2020/4/14
 * @Version 1.0
 */
@Slf4j
public class OssimgUtil {
    /**
     * file转MultipartFile
     * @param file
     * @return
     */
    public static MultipartFile convertFile(File file) throws IOException {
        InputStream fis = new FileInputStream(file);
        System.out.println(fis.available());
        byte[] data= new byte[fis.available()];
        fis.read(data);
        fis.close();
        return new MockMultipartFile(file.getPath(), data);
    }
    public  static String getFile(HttpServletRequest request)  {
        Collection<Part> files = null;
        try {
            files = request.getParts();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        Iterator<Part> iterator = files.iterator();
        String path = "";
        Part part = iterator.next();
        try {
            part.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = UUID.randomUUID().toString();
        String path1 = null;
        try {
            path1 = ResourceUtils.getURL("classpath：").getPath().toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            path = ResourceUtils.getURL("classpath：").getPath() + name + ".jpg";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] b = new byte[1024];
        int len = 0;
        FileInputStream fis = null;
        try {
            fis = (FileInputStream) part.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        while ((len = fis.read(b)) != -1) {

            fileOutputStream.write(b, 0, len);

            } } catch (IOException e) {
            e.printStackTrace();
        }
        assert fileOutputStream != null;
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
public static File sy (File file1){
    ImgUtil.pressText(//
            FileUtil.file(file1), //
            FileUtil.file(file1),
            "知乎", Color.BLACK, //文字
            new Font("黑体", Font.BOLD, 100), //字体
            0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
            0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
            0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
    );
    return file1;
}

    /**
     * 将接收的MultipartFile数组转为File数组
     *
     * @param sourceFiles
     * @return
     */
    public static java.util.List<File> getFiles(MultipartFile[] sourceFiles) {
        List<File> fileList = new ArrayList<>(sourceFiles.length);
        for (MultipartFile sourceFile : sourceFiles) {
            // 获取文件名
            String fileName = sourceFile.getOriginalFilename();
            //uuid生成主文件名
            String prefix = UUID.randomUUID().toString();
            assert fileName != null;
            //源文件的扩展名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //创建File类型的临时文件
            File tempFile;
            try {
                tempFile = File.createTempFile(prefix, suffix);
                sourceFile.transferTo(tempFile);
                fileList.add(tempFile);
            } catch (IOException transferToe) {
                transferToe.printStackTrace();
            }
        }
        return fileList;
    }

    public static List<String> upload(MultipartFile[] sourceFiles) {
        List<String> tempFiles = new ArrayList<>(10);
        for (MultipartFile sourceFile : sourceFiles) {

            // 获取文件名
            String fileName = sourceFile.getOriginalFilename();
            //uuid生成主文件名
            String prefix = UUID.randomUUID().toString();
            assert fileName != null;
            //源文件的扩展名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //创建File类型的临时文件
            File tempFile;
            try {
                tempFile = File.createTempFile(prefix, suffix);
                System.out.println(tempFile);
                // 将MultipartFile转换成File
                sourceFile.transferTo(tempFile);
                tempFiles.add(upload(tempFile));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return tempFiles;
    }
    /**
     * 将单个文件上传到阿里对象存储
     *
     * @param file
     * @return
     */
    public static String upload(File file) {
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI4Fomj1SE25BiCMP4N1PH";
        String accessKeySecret = "sGONg7XTpY3dHRLafqR6u1DYP3Kpi4";
        String bucketName = "space1821";
        String filePath = "UserAvatar/";
        String fileName = file.getName();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//        ossClient.set
        // 上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName, filePath + newFileName, file);
        // 拼接URL
        String url = "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/" + filePath + newFileName;
        ossClient.shutdown();
        return url;
    }

    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\林小派\\Desktop\\刘璇\\1.jpg");
        String s = upload(file1);
        System.out.println(s);

    }
}
