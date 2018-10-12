/*
1、创建一个person对象的一维数组； 对象的年龄和班级随机生成；
   对数组按照学号排序
   输出排序后的数组

*/
    class Person{
    	int age ;
    	int number ;
    	int classes;
    	Person(){
    		age = (int)(Math.random()*100+10);
    	    number = (int)(Math.random()*100+10);
            classes = (int)(Math.random()*100+10);
    	}

    	public static void main(String[] args){
    		Person[] p = new Person[20];
            for(int i=0; i<p.length; i++){
                p[i]= new Person();
            }

            for(int i=0; i<p.length; i++){
                System.out.print("  学号 " + p[i].number);
                System.out.print("  班级 " + p[i].classes);
                System.out.print("  年龄 " + p[i].age);
                System.out.println("");
            }
            System.out.println();
            // 冒泡排序
    		for(int i=0; i < p.length; i++){
    			for(int j=0; j < p.length-i-1; j++){
    				if(p[j].classes > p[j+1].classes){

                        Person tmp = p[j];
                        p[j] = p[j+1];
                        p[j+1] = tmp;
    				}
    			}	
    		}
    		for(int i=0; i<p.length; i++){
    			System.out.print("  学号 " + p[i].number);
    			System.out.print("  班级 " + p[i].classes);
    			System.out.print("  年龄 " + p[i].age);
                System.out.println("");
    		}
    	}
    }

