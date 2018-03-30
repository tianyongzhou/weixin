package com.tyz.weixin.utils;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: Http Get/Post 工具类
 * @Date: 2017/12/7.
 * @Modified: tyz
 */
public class HttpClientUtils {
    /**
     * 最大线程池
     */
    public static final int THREAD_POOL_SIZE = 2;

    public interface HttpClientDownLoadProgress {
         void onProgress(int progress);
    }

    private static HttpClientUtils httpClientDownload;
    private ExecutorService downloadExcutorService;

    private HttpClientUtils() {
        downloadExcutorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public static HttpClientUtils getInstance() {
        if (httpClientDownload == null) {
            httpClientDownload = new HttpClientUtils();
        }
        return httpClientDownload;
    }

    /**
     * @Author: tyz
     * @Description: 下载文件
     * @param url 下载文件地址
     * @param saveFilePath
     * @param progress 进度回调
     * @param headMap 请求头信息
     * @Date 16:24 2017/12/7
     * @return
     */
    public void download(final String url, final String saveFilePath, final HttpClientDownLoadProgress progress, final Map<String, String> headMap) {
        downloadExcutorService.execute(new Runnable() {
            @Override
            public void run() {
                LogUtils.log("currentThd="+Thread.currentThread().getId());
                httpDownloadFile(url, saveFilePath, progress, headMap);
            }
        });
    }

    /**
     * @Author: tyz
     * @Description: 下载文件
     * @param saveFilePath
     * @Date 16:35 2017/12/7
     * @return
     */
    private void httpDownloadFile(String url, String saveFilePath, HttpClientDownLoadProgress progress, Map<String, String> headMap) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            setGetHead(httpGet, headMap);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity httpEntity = response1.getEntity();
                long contentLength = httpEntity.getContentLength();
                InputStream is = httpEntity.getContent();
                // 根据InputStream 下载文件
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int r = 0;
                long totalRead = 0;
                while ((r = is.read(buffer)) > 0) {
                    output.write(buffer, 0, r);
                    totalRead += r;
                    if (progress != null) {// 回调进度
                        progress.onProgress((int) (totalRead * 100 / contentLength));
                    }
                }
                FileOutputStream fos = new FileOutputStream(saveFilePath);
                output.writeTo(fos);
                output.flush();
                output.close();
                fos.close();
                EntityUtils.consume(httpEntity);
            } finally {
                response1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Author: tyz
     * @Description: get请求
     * @param headMap
     * @Date 16:44 2017/12/7
     * @return
     */
    public static String httpGet(String url, Map<String, String> headMap) {
        String responseContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            setGetHead(httpGet, headMap);
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity entity = response1.getEntity();
                responseContent = getRespString(entity);
                System.out.println("debug:" + responseContent);
                EntityUtils.consume(entity);
            } finally {
                response1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    public static JSONObject httpGetJson(String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        JSONObject json = null;
        try {
            CloseableHttpResponse res = httpclient.execute(get);
            try {
                if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity entity = res.getEntity();
                    String reslut = getRespString(entity);
                    json = JSONObject.fromObject(reslut);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                res.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            //关闭连接 ,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }

    /**
     * @Author: tyz
     * @Description: post请求
     * @param paramsMap 参数集合
     * @param headMap 请求头信息
     * @Date 16:45 2017/12/7
     * @return
     */
    public static String httpPost(String url, Map<String, String> paramsMap, Map<String, String> headMap) {
        String responseContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(url);
            setPostHead(httpPost, headMap);
            setPostParams(httpPost, paramsMap);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                responseContent = getRespString(entity);
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("responseContent = " + responseContent);
        return responseContent;
    }

    public static JSONObject httpPostJson(String url,String json){
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json, "UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.fromObject(result);
            }
        } catch (Exception e) {
           // throw new RuntimeException(e);
        }
        return response;
    }

    /**
     * 设置POST的参数
     *
     * @param httpPost
     * @param paramsMap
     * @throws Exception
     */
    private static void setPostParams(HttpPost httpPost, Map<String, String> paramsMap)
            throws Exception {
        if (paramsMap != null && paramsMap.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<String> keySet = paramsMap.keySet();
            for (String key : keySet) {
                nvps.add(new BasicNameValuePair(key, paramsMap.get(key)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        }
    }

    /**
     * 设置http的HEAD
     *
     * @param httpPost
     * @param headMap
     */
    private static void setPostHead(HttpPost httpPost, Map<String, String> headMap) {
        if (headMap != null && headMap.size() > 0) {
            Set<String> keySet = headMap.keySet();
            for (String key : keySet) {
                httpPost.addHeader(key, headMap.get(key));
            }
        }
    }

    /**
     * 设置http的HEAD
     *
     * @param httpGet
     * @param headMap
     */
    private static void setGetHead(HttpGet httpGet, Map<String, String> headMap) {
        if (headMap != null && headMap.size() > 0) {
            Set<String> keySet = headMap.keySet();
            for (String key : keySet) {
                httpGet.addHeader(key, headMap.get(key));
            }
        }
    }

    /**
     * @Author: tyz
     * @Description:上传文件
     * @param serverUrl
     *            服务器地址
     * @param localFilePath
     *            本地文件路径
     * @param serverFieldName
     * @param params
     * @Date 16:50 2017/12/7
     * @return
     */
    public String uploadFile(String serverUrl, String localFilePath, String serverFieldName, Map<String, String> params)
            throws Exception {
        String respStr = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(serverUrl);
            FileBody binFileBody = new FileBody(new File(localFilePath));

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder
                    .create();
            // add the file params
            multipartEntityBuilder.addPart(serverFieldName, binFileBody);
            // 设置上传的其他参数
            setUploadParams(multipartEntityBuilder, params);

            HttpEntity reqEntity = multipartEntityBuilder.build();
            httppost.setEntity(reqEntity);

            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                respStr = getRespString(resEntity);
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        System.out.println("resp=" + respStr);
        return respStr;
    }

    /**
     * 设置上传文件时所附带的其他参数
     *
     * @param multipartEntityBuilder
     * @param params
     */
    private void setUploadParams(MultipartEntityBuilder multipartEntityBuilder,
                                 Map<String, String> params) {
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                multipartEntityBuilder.addPart(key, new StringBody(params.get(key), ContentType.TEXT_PLAIN));
            }
        }
    }

    /**
     * 将返回结果转化为String
     *
     * @param entity
     * @return
     * @throws Exception
     */
    private static String getRespString(HttpEntity entity) throws Exception {
        if (entity == null) {
            return null;
        }
        InputStream is = entity.getContent();
        StringBuffer strBuf = new StringBuffer();
        byte[] buffer = new byte[4096];
        int r = 0;
        while ((r = is.read(buffer)) > 0) {
            strBuf.append(new String(buffer, 0, r, "UTF-8"));
        }
        return strBuf.toString();
    }


    public static void main(String[] args) {
        /**
         * 测试下载文件 异步下载
         */
        HttpClientUtils.getInstance().download(
                //"http://bpic.ooopic.com/17/34/38/69bOOOPICa5.mp4", "bg.mp4",
                "https://github-production-release-asset-2e65be.s3.amazonaws.com/3606738/c3650a92-efbb-11e7-8611-da30a598327f?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20180108%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20180108T014546Z&X-Amz-Expires=300&X-Amz-Signature=830f9cbc81ea4794aa38cf91dfad8837663258c575a20b0b4263d4aeffaba19b&X-Amz-SignedHeaders=host&actor_id=0&response-content-disposition=attachment%3B%20filename%3DCesium-1.41.zip&response-content-type=application%2Foctet-stream", "cesium.zip",
                new HttpClientDownLoadProgress() {
                    @Override
                    public void onProgress(int progress) {
                       // if(progress==100)
                        System.out.println("download progress = " + progress);
                    }
                }, null);

        // POST 同步方法
      /*  Map<String, String> params = new HashMap<String, String>();
        params.put("username", "admin");
        params.put("password", "admin");
        HttpClientUtils.getInstance().httpPost(
                "http://192.168.31.183:8080/SSHMySql/register", params, null);*/

        // GET 同步方法
      /*  HttpClientUtils.getInstance().httpGet("http://wthrcdn.etouch.cn/weather_mini?city=北京", null);*/

        // 上传文件 POST 同步方法
        /*try {
            Map<String, String> uploadParams = new LinkedHashMap<String, String>();
            uploadParams.put("userImageContentType", "image");
            uploadParams.put("userImageFileName", "testaa.png");
            HttpClientUtils.getInstance().uploadFile(
                    "http://192.168.31.183:8080/SSHMySql/upload", "android_bug_1.png",
                    "userImage", uploadParams);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
