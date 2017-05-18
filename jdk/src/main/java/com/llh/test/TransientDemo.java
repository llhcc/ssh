package com.llh.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//Serializable接口没有任何需要实现的方法，实现这个接口是为了声明这个对象可以序列化
public class TransientDemo implements Serializable{
 private static final long serialVersionUID = 1L;
 String name;
 //用了transient这个关键字，这个字段就不会被序列化了
 transient String password;
 public TransientDemo(String name, String password) {
  this.name = name;
  this.password = password;
 }
 @Override
 public String toString() {
  return name + ":" + password;
 }
 public static void main(String[] args) {
  TransientDemo td = new TransientDemo("Yinyan", "love");
  try{
   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e://log.txt"));
   oos.writeObject(td);
   oos.close();
  }catch(Exception e){
   e.printStackTrace();
  }
  
  try{
   ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e://log.txt"));
   TransientDemo td2 = (TransientDemo) ois.readObject();
   System.out.println(td2);
  }catch(Exception e){
   e.printStackTrace();
  }
 }
}
