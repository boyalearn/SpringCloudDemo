package com.spring.cloud;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class EncryptTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault(); 
		// 发送post请求 
		HttpPost post = new HttpPost("http://localhost:8888/encrypt"); 
		// 设置请求的参数，对20180323进行加密，编码格式为UTF-8 
		HttpEntity entity = new StringEntity("18328508416", Consts.UTF_8); 
		post.setEntity(entity); 
		HttpResponse response = client.execute(post); 
		System.out.println(EntityUtils.toString(response.getEntity()));
		

	}
	public static void main2(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault(); 
		// 发送post请求
		HttpPost post = new HttpPost("http://localhost:8888/decrypt"); 
		// 设置请求的参数，对2cdf324e7d8c6271d883a7a9bdcac532d027141545f1fed273f8c2b803bc3e9d进行解密，编码格式为UTF-8 
		HttpEntity entity = new StringEntity("60cf4bc36d254efd745c47bb33302c82467e2fd30238a9ab7e55a5aaaa95badd", Consts.UTF_8); 
		post.setEntity(entity); HttpResponse response = client.execute(post); 
		System.out.println(EntityUtils.toString(response.getEntity()));

	}

}
