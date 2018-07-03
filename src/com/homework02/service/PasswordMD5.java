package com.homework02.service;


public class PasswordMD5 {

	/**1.
     * 生成32位md5码
     * @param password
     * @return
     */
//    public static String md5Password(String password) {
//
//        try {
//            // 得到一个信息摘要器
//            MessageDigest digest = MessageDigest.getInstance("md5");
//            byte[] result = digest.digest(password.getBytes());
//            StringBuffer buffer = new StringBuffer();
//            // 把每一个byte 做一个与运算 0xff;
//            for (byte b : result) {
//                // 与运算
//                int number = b & 0xff;// 加盐
//                String str = Integer.toHexString(number);
//                if (str.length() == 1) {
//                    buffer.append("0");
//                }
//                buffer.append(str);
//            }
//
//            // 标准的md5加密后的结果
//            return buffer.toString();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return "";
//        }
//
//    }
    
    /** 2.
     * 加密解密算法 执行一次加密，两次解密 
     */ 
	public static String md5Password(String inStr){  
	
	    char[] a = inStr.toCharArray();  
	    for (int i = 0; i < a.length; i++){  
	        a[i] = (char) (a[i] ^ 't');  
	    }  
	    String s = new String(a);  
	    return s;  
	}
	
}
