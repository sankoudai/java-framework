import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

import java.io.StringWriter;

/**
 * @author : sankoudai
 * @version : created at 2015/11/6
 */
public class HelloVelocity {
    public static void main(String[] args) throws Exception {
        /* template */
        Velocity.init();
        Template template = Velocity.getTemplate("framework-velocity/src/main/resources/helloTemplate.vm");

        /* context(data) */
        Context context = new VelocityContext();
        context.put("hello", "Hello Velocity!");

        /* merge */
        StringWriter buf = new StringWriter();
        template.merge(context, buf);

        System.out.printf("template + data = \n\n %s \n", buf.toString());
    }
}
