/**
 * MIT License
 * <p>
 * Copyright (c) 2017 James
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package me.zbl.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * Interpreter
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    try {
      String tokenString = "5 3 2 1 + 2 * 3 /";
      Stack<Expression> stack = new Stack<>();

      String[] stringList = tokenString.split(" ");
      for (String s : stringList) {
        if (isOperator(s)) {
          Expression expressionRight = stack.pop();
          Expression expressionLeft = stack.pop();
          LOGGER.info("左操作数：{}，右操作数：{}", expressionLeft.interpret(), expressionRight.interpret());
          Expression expression = getExpressionInstance(s, expressionLeft, expressionRight);
          LOGGER.info("操作符：{}", expression);
          Expression result;
          if (expression != null) {
            result = new NumberExpression(expression.interpret());
            LOGGER.info("运算结果为：{}", result.interpret());
            stack.push(result);
          }
        } else {
          NumberExpression expression = new NumberExpression(s);
          stack.push(expression);
          LOGGER.info("数字入栈：{}", expression.interpret());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 判断字符串是否为四则运算的操作符
   *
   * @param s 待判断的字符串
   *
   * @return 是否为操作符
   */
  public static boolean isOperator(String s) {
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
  }

  /**
   * 根据字符串生成四则运算表达式
   *
   * @param s               字符串
   * @param expressionLeft  左表达式
   * @param expressionRight 右表达式
   *
   * @return 四则运算表达式
   */
  public static Expression getExpressionInstance(String s, Expression expressionLeft, Expression expressionRight) {
    if (isOperator(s)) {
      switch (s) {
        case "+": {
          return new PlusExpression(expressionLeft, expressionRight);
        }
        case "-": {
          return new MinusExpression(expressionLeft, expressionRight);
        }
        case "*": {
          return new MultipleExpression(expressionLeft, expressionRight);
        }
        case "/": {
          return new DivisionExpression(expressionLeft, expressionRight);
        }
      }
    }
    return null;
  }
}
