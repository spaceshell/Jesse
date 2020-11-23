package com.spaceshell.polymorphic.SearchPerson;

/**
 * @author: Jesse
 * @date: 2020/11/23 10:12
 */
public class TestPerson {
  public static void main(String[] args) {

    Person[] ps = new Person[10];

    ps[0] = new TargetPerson("目标1");
    ps[1] = new NormalPerson("非目标1");
    ps[2] = new NormalPerson("非目标2");
    ps[3] = new TargetPerson("目标2");
    ps[4] = new TargetPerson("目标3");
    ps[5] = new NormalPerson("非目标3");
    ps[6] = new TargetPerson("目标4");
    ps[7] = new NormalPerson("非目标4");
    ps[8] = new NormalPerson("非目标5");
    ps[9] = new TargetPerson("目标5");

    TargetPerson[] tp = searchAllTargetPerson(ps);  //调用searchAllTargetPerson函数
    for(int i = 0; i < tp.length; i++){
      System.out.println(tp[i].getName());
    }

  }

  /**
   * 将一组Person中的所有目标对象挑选出来，并保存在一个Person类型的数组中，进行返回。
   * @param persons
   * @return
   */
  public static TargetPerson[] searchAllTargetPerson(Person[] persons){

    //0.定义计数器
    int count = 0;

    //1. 先数一遍数组中共有多少目标对象，再创建数组
    for (int  i = 0; i < persons.length; i++){
      //1.1 对数组中每个元素进行类型判断
      if(persons[i] instanceof TargetPerson){
        //1.2 每发现一个目标对象，计数器自增一
        count++;
      }
    }

    //2.根据级数记数结果，创建疮毒合适的Person数组
    TargetPerson[] targetPersons = new TargetPerson[count];

    //3.定义TargetPerson的有效元素个数（计数器）
    int size = 0;

    //4.将persons中的所有TargetPerson对象，保存在TargetPerson数组中
    for(int i = 0; i <persons.length; i++){
      //4.1判断是否为TargetPerson类型
      if(persons[i] instanceof TargetPerson){
        //4.2 将Person数组元素，进行强制类型转换后，保存在TargetPerson数组中
        targetPersons[size++] = (TargetPerson)persons[i];
      }
    }
    return targetPersons;
  }
}

class Person{
  private String name;

  public Person(){
    super();//隐式存在
  }

  public Person(String name){
    this.name = name;
  }

  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return this.name;
  }
}

class TargetPerson extends Person{
  public TargetPerson(){}
  public TargetPerson(String name){
    super(name);   //调用父类的有参构造方法，访问getName方法就可以拿到属性值
  }
}

class NormalPerson extends Person{
  public NormalPerson(){}
  public NormalPerson(String name){
    super(name);
  }
}
