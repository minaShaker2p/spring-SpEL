package com.mina.spelDemo;

import com.mina.spelDemo.data.User;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class AppExpressionParser {

    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();

        Expression exp1 = parser.parseExpression("'Mina Rezkalla'");
        String message = (String) exp1.getValue();
        System.out.println(message);

        Expression exp2 = parser.parseExpression("'Mina Rezkalla'.length()");
        System.out.println(exp2.getValue());

        Expression exp3 = parser.parseExpression("'Mina Rezkalla'.length() * 30");
        System.out.println(exp3.getValue());

        Expression exp4 = parser.parseExpression("'Mina Rezkalla'.length() > 10 ");
        System.out.println(exp4.getValue());


        Expression exp5 = parser.parseExpression("'Mina Rezkalla'.length() > 10 and " +
                "  'Mina Rezkalla'.length() < 10");
        System.out.println(exp5.getValue());

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("greeting", "Hello Egypt");
        String msg = (String) parser.parseExpression("#greeting.substring(6)").getValue(evaluationContext);
        System.out.println(msg);
        User user = new User();
        StandardEvaluationContext userContext = new StandardEvaluationContext(user);

        StandardEvaluationContext propsContext = new StandardEvaluationContext();

        propsContext.setVariable("systemProperties", System.getProperties());

        Expression expCountry = parser.parseExpression("#systemProperties['user.country']");
        parser.parseExpression("country").setValue(userContext, expCountry.getValue(propsContext));
        System.out.println(user.getCountry());

        Expression expLanguage = parser.parseExpression("#systemProperties['user.language']");
        parser.parseExpression("language").setValue(userContext, expLanguage.getValue(propsContext));
        System.out.println(user.getLanguage());

    }
}
