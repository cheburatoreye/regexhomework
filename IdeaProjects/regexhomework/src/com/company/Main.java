package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

     static final boolean checkData(String string){
         String string1=string;
         boolean condition1=false;
         boolean condition2=false;
         boolean condition3=false;
         boolean condition4=false;

         /*
         проверяю что введенная конструкция верна
         (слова с заглавной буквы,через пробелы,русские или английские и только буквы без знаков и цифр)
          */
         Pattern p = Pattern.compile("^(([A-Z]{1}[a-z]+\\s)|([А-Я]{1}(([а-я])|([ё+]))+\\s))" +
                 "(([A-Z]{1}[a-z]+\\s)|([А-Я]{1}(([а-я])|([ё+]))+\\s))" +
                 "(([A-Z]{1}[a-z]+)|([А-Я]{1}(([а-я])|([ё+]))+))$");
         Matcher m = p.matcher(string1);
         if(m.find()){
             condition1=true;//
         }
         m.reset();

        //проверяю второе слово на английские буквы
         p = Pattern.compile("^(([A-Z]{1}[a-z]+\\s)|([А-Я]{1}(([а-я])|([ё+]))+\\s))" +
                 "[A-Z]{1}[a-z]+\\s" +
                 "(([A-Z]{1}[a-z]+)|([А-Я]{1}(([а-я])|([ё+]))+))$");
         m = p.matcher(string1);

         if(m.find()){
             condition2=true;//проверяю второе слово на английские буквы
         }
         m.reset();


         //проверяю третье слово на английские буквы
         p = Pattern.compile("^(([A-Z]{1}[a-z]+\\s)|([А-Я]{1}(([а-я])|([ё+]))+\\s))" +
                 "(([A-Z]{1}[a-z]+\\s)|([А-Я]{1}(([а-я])|([ё+]))+\\s))" +
                 "[A-Z]{1}[a-z]+$");
         m = p.matcher(string1);

         if(m.find()){
             condition3=true;//проверяю третье слово на английские буквы
         }
         m.reset();


         //проверяю первое слово на английские буквы
         p = Pattern.compile("^[A-Z]{1}[a-z]+\\s" +
                 "(([A-Z]{1}[a-z]+\\s)|([А-Я]{1}(([а-я])|([ё+]))+\\s))" +
                 "(([A-Z]{1}[a-z]+)|([А-Я]{1}(([а-я])|([ё+]))+))$");
         m = p.matcher(string1);

         if(m.find()){
             condition4=true;//
         }


        //Проверяю условие на кондицию данных
         if(condition1&condition2&condition3&condition4|condition1&!condition2&!condition3&!condition4){
             return true;
         }
         else {
             return false;
         }


    }


    public static void main(String[] args) {
	        boolean correctdata=false;//булевое значение корректных данных
	        correctdata=checkData("Чабаненко Александр Александрович");//подаю в метод строку ФИО

        //вывод в консоль правильные данные или нет
        if(correctdata){
            System.out.println("\ndata correct");
        }
        else {
            System.out.println("\ndata not correct");
        }

    }
}
