package com.zh.myjdk;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ZhProxy {
    public static Object newProxyInstance(ZhClassLoader classLoader, Class<?>[] interfaces, ZhInvocationHandler h) throws IllegalArgumentException{
        try {
            //生成Java文件
            int i=0;
            String s=generateJava(interfaces,i);
            //输出磁盘
            String name=nameSpace+i;
            File file=new File(name+".java");
            FileWriter fw=new FileWriter(file);
            fw.write(s);
            fw.flush();
            fw.close();
            //编译成class
            JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager=compiler.getStandardFileManager(null,null,null);
            Iterable iterable=manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task=compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();

            //加载到jvm

            Class<?>clazz=classLoader.findClass(name);
            Constructor c = clazz.getConstructor(ZhInvocationHandler.class);
            return c.newInstance(h);

            //返回代理类
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return null;
    }

    private final static String ln="\r\n";
    private final static String nameSpace="$proxy";
    private static String generateJava(Class<?>[] interfaces,int i) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.zh.myjdk;").append(ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("import com.zh.jdk.Person;" + ln);

                sb.append("public class ").append(nameSpace).append(i).append("   implements ").append(interfaces[i].getName()).append(" {").append(ln)

                .append("ZhInvocationHandler h;").append(ln)

                //构造器
                .append("public ").append(nameSpace).append(i).append("(ZhInvocationHandler h)").append("{").append(ln)
                    .append("this.h =h;").append(ln)
                .append(" }").append(ln);

                //组建方法
                for(Method method:interfaces[i].getMethods()){
                    sb.append("public ").append(method.getReturnType()).append("  ").append(method.getName()).append("  (){").append(ln);
                        sb.append("try{").append(ln);
                            sb.append("Method m=").append(interfaces[i].getName()).append(".class.getMethod(\"").append(method.getName()).append("\",").append("new Class[]{});").append(ln);
                            sb.append("this.h.invoke(this,m,null);" + ln);
                        sb.append(" }catch(Throwable e){").append(ln);
                            sb.append("e.printStackTrace();");
                        sb.append(" }").append(ln);
                    sb.append(" }").append(ln);
                }

                sb.append(" }").append(ln);

        return sb.toString();
    }
}
