package cn.mylava.Tmp;

import cn.mylava.Tmp.test.SignConf;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.HashedMap;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author lipengfei
 */
public class TestSign {

    public static String insetBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-'
                    || s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }
        return result;
    }

    //这个函数的作用就是处理栈中的两个数据，然后将栈中的两个数据运算之后将结果存储在栈中
    public static void processAnOperator(Stack<String> operandStack, Stack<Character> operatorStack, SignConf signConf) {
        char op = operatorStack.pop();
        String op1 = operandStack.pop();
        String op2 = operandStack.pop();
        if (op == '+')  //如果操作符为+就执行加运算
            operandStack.push(op2 +"+"+op1);
        else if (op == '*')
            if ("C".equals(op1)) {
                if (signConf.getSort().equals("ASCE")) {
                    operandStack.push("("+op2+")*升序");
                } else if (signConf.getSort().equals("DESC")) {
                    operandStack.push("("+op2+")*降序");
                }
            } else if ("D".equals(op1)) {
                if (signConf.getEncryp().equals("MD5")){
                    operandStack.push("("+op2+")*MD5");
                } else if (signConf.getEncryp().equals("SHA1")) {
                    operandStack.push("("+op2+")*SHA1");
                }
            } else if ("E".equals(op1)) {
                if (signConf.getCaseStr().equals("UPPER")){
                    operandStack.push("("+op2+")*转大写");
                } else if (signConf.getCaseStr().equals("LOWER")) {
                    operandStack.push("("+op2+")*转小写");
                }
            } else {
                System.out.println("表达式错误");
                System.out.println("-----"+op1);
            }
    }


    public static String evaluateExpression(String expression, SignConf signConf) {
        //操作数
        Stack<String> operandStack = new Stack<>();
        //操作符号
        Stack<Character> operatorStack = new Stack<>();
        expression = insetBlanks(expression);
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.length() == 0) {  //如果是空格的话就继续循环，什么也不操作
                continue;
                //如果是加的话，因为加的优先级最低，因此这里的只要遇到加号，无论操作符栈中的是什么运算符都要运算
            } else if (token.charAt(0) == '+') {
                //当栈不是空的，并且栈中最上面的一个元素是加或乘的人任意一个
                while (!operatorStack.isEmpty()&&(operatorStack.peek() == '+' || operatorStack.peek() == '*')) {
                    processAnOperator(operandStack, operatorStack, signConf);   //开始运算
                }
                operatorStack.push(token.charAt(0));   //运算完之后将当前的运算符入栈
            } else if (token.charAt(0) == '*') {//当前运算符是乘的时候，判断栈顶元素否是乘，如果是乘就运算，否则的话直接入栈
                while (!operatorStack.isEmpty()&&operatorStack.peek() == '*') {
                    processAnOperator(operandStack, operatorStack, signConf);
                }
                operatorStack.push(token.charAt(0));   //将当前操作符入栈
            } else if (token.trim().charAt(0) == '(') {
                //如果是左括号的话直接入栈，什么也不用操作,trim()函数是用来去除空格的，由于上面的分割操作可能会令操作符带有空格
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                //如果是右括号的话，执行栈中的运算符直至左括号
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack, signConf);    //开始运算
                }
                operatorStack.pop();   //这里的是运算完之后清除左括号
            } else { //操作数处理，直接压栈
                if ("A".equals(token)) {
                    operandStack.push(signConf.getSecrect());
                } else if ("B".equals(token)) {
                    operandStack.push(signConf.getParams());
                } else {
                    operandStack.push(token);
                }
            }
        }
        //最后当栈中不是空的时候继续运算，知道栈中为空即可
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack, signConf);
        }
        return operandStack.pop();    //此时数据栈中的数据就是运算的结果
    }

    public static void main(String[] args) {
        //(A+(B*C)*D+A)*E   A serect     B 待加密参数   C  加密方式  D  大小写  E 排序
        String expression = "(A+(B*C)*D+A)*E";
        SignConf conf = new SignConf();
        conf.setSecrect("A");
        conf.setParams("xx=yy&aa=bb");
        conf.setEncryp("MD5");
        conf.setCaseStr("UPPER");
        conf.setSort("DESC");

        String result = evaluateExpression(expression,conf);
        System.out.println(result);

    }
}
