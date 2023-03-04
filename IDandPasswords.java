import java.util.HashMap;
//user passwords
public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		logininfo.put("admin","admin");
		logininfo.put("101@room","ram@678");
		logininfo.put("102@room","sam#123");
		logininfo.put("103@room","ved$888");
		logininfo.put("104@room","ans!789");
		logininfo.put("105@room","ani%564");
		logininfo.put("106@room","chi^636");
		logininfo.put("107@room","man&555");
		logininfo.put("108@room","par*420");
		logininfo.put("109@room","var(525");
		logininfo.put("110@room","par!526");
		logininfo.put("111@room","fin@444");
		logininfo.put("112@room","jan#656");
		logininfo.put("113@room","ffs&151");
		logininfo.put("114@room","wfe*000");
		logininfo.put("115@room","bad*252");
		logininfo.put("116@room","kkk@222");
		logininfo.put("117@room","lol&001");
		logininfo.put("118@room","oop%030");
		logininfo.put("119@room","kki$071");
		logininfo.put("120@room","lal@999");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}