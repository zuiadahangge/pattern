package com.zh.myjdk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ZhClassLoader extends ClassLoader{


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className = ZhClassLoader.class.getPackage().getName() + "." + name;

        File classFile = new File(name.replaceAll("\\.","/") + ".class");
        if(classFile.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;

            try{
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte [] buff = new byte[1024];
                int len;
                while ((len = in.read(buff)) != -1){
                    out.write(buff,0,len);
                }
                return  defineClass(className,out.toByteArray(),0,out.size());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(null != in){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(out != null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        return null;


    }
}
