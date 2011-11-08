package com.svp;


import java.lang.reflect.Array;
import java.net.URI;
import java.util.HashMap;

import org.xmlrpc.android.XMLRPCClient;
import org.xmlrpc.android.XMLRPCException;

import android.net.sip.SipRegistrationListener;
import android.util.Log;


public class SvpClient {

	protected static SvpClient instance;
	
	protected String url = "http://test9.somvprahe.sk/xmlrpc/mobile-services-auth";
	
	
	protected String sessionID = "";
	protected String session_name;
	protected XMLRPCClient client;
	
	public SvpUserEntity svpUser;
	
	public static SvpClient getInstance() {
		
		
		if(SvpClient.instance == null) {
			SvpClient.instance = new SvpClient();
		}
		
		return SvpClient.instance;
		
	}
	
	 
	
	protected XMLRPCClient getClient()  {
		
		if(client == null ) {
			client = new XMLRPCClient(url);
		}
		
		return client;
		
	}
	public boolean auth(String username, String pwd) {
		
		
		sessionID = "";
		try {
			
			Log.v("svpclient", "logging in");
			
			HashMap<String, String> res = (HashMap<String, String>) getClient().call("user.login",username,pwd);
			
			sessionID = res.get("sessid");
			session_name = res.get("session_name");
			Log.v("svpclient", res.toString());
			
			
			HashMap<String, String> ss = new HashMap<String,String>();
			ss.put("Cookie",session_name + "=" + sessionID);
			client = new XMLRPCClient(URI.create(url), ss );
			
			
		} catch (XMLRPCException e) {
			// TODO Auto-generated catch block
			Log.v("svpclient", "logging failed");
			e.printStackTrace();
		}
		
		Log.v("svpclient", "logging finished");
		
		return isLoggedIn();
		
	}
	
	public boolean isLoggedIn() {
		
		return (sessionID!="");
	}
	
	public int getMessagesCount() {
		
		
		try {
			
			Log.v("svpclient", "getting messages count with session id: "+url);
			

			HashMap<String, String> ss = new HashMap<String,String>();
			ss.put("Cookie",session_name + "=" + sessionID);
			
			XMLRPCClient cl2 = new XMLRPCClient(new URI(url),ss );
			
			
			String res =  (String) cl2.call("privatemsg.unreadCount");
			
			
			Log.v("svpclient", res.toString());
			
			
		} catch (Exception e) {
			
			Log.v("svpclient", "getting messages count FAILED" );
			// TODO: handle exception
			e.printStackTrace();
			
			
		}
		
		Log.v("svpclient", "getting messages count END" );
		
		return 0;
		
		
	}
	
	public String getNode() {
		
		XMLRPCClient client = new XMLRPCClient("http://test9.somvprahe.sk/xmlrpc/mobile-services-auth");
		Log.v("svpclient", "svpclient get node");
		//XMLRPCClient client = new XMLRPCClient("http://drupal.cooladmin.cz:81/xmlrpc.php");
		
		
		try {
			Log.v("svpclient", "svpclient before call");
			//String res = (String)
			String res;// = client.call("node.retrieve","73731").toString();
			
			Object node = (Object) client.call("node.retrieve","73731");
			
			res = node.toString();
			//String res = (String) client.call("svpxmlrpc.foo","janc=-i");
			Log.v("svpclient", "svpclient after call");
			Log.v("svpclient",res);
			
			return res;
			
		} catch (XMLRPCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "failed";
		
	}
	
	
	public SvpMessageEntity[] getMessages() {
		
		Log.v("svpclient", "svpclient get list");
		
		try {
			Log.v("svpclient", "connecting ... to " + url);
			
			HashMap<String, String>[] nodes;
			
			nodes = (HashMap<String, String>[]) getClient().call("privatemsg.get","inbox","","1","15");
			
			//Object[] nn = (Object[]) getClient().call("privatemsg.get","inbox","","1","15");
			
			
			for(Object n : nodes ) {
				
				Log.v("svpclient",n.toString());
				
			}
 			
			//Object ob = (Object) client.call("privatemsg.unreadCount");
			
			Log.v("svpclient", "connected. parsing data .." );
			
			SvpMessageEntity[] result = new SvpMessageEntity[10];
			
			int i = 0;
			for(HashMap<String, String> n : nodes) {
				if(i<2) {
					result[i++] = new SvpMessageEntity(n);
				}
				
			}
			//Log.v("svpclient", nodes);
			
			//String res = (String) client.call("svpxmlrpc.foo","janci");
			
			return result;
			
		} catch (XMLRPCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public SvpArticleEntity[] getArticles() {
		
		

		Log.v("svpclient", "svpclient get list");
		
		try {
			Log.v("svpclient", "connecting ... to " + url);
			
			HashMap<String, String>[] nodes;
			
			nodes = (HashMap<String, String>[]) getClient().call("node.index","");
			//Object ob = (Object) client.call("privatemsg.unreadCount");
			
			Log.v("svpclient", "connected. parsing data .." );
			
			SvpArticleEntity[] result = new SvpArticleEntity[10];
			int i = 0;
			for(HashMap<String, String> n : nodes) {
				if(i<10) {
					result[i++] = new SvpArticleEntity(n);
				}
				
			}
			//Log.v("svpclient", nodes);
			
			//String res = (String) client.call("svpxmlrpc.foo","janci");
			
			return result;
			
		} catch (XMLRPCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
}
