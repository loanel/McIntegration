package misows.mcIntegration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Expression;
import java.util.Random;

@RestController
public class IntegrationController {

    @RequestMapping("/mcintegrate")
    public double mcIntegration(@RequestParam(value="amount") Double amount, @RequestParam(value="nodes") Integer nodes){
        double pointsInCircle = 0;
        Random rand = new Random();
        for (double i = 0; i < amount; i++) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();
            if(Math.pow(x, 2) + Math.pow(y, 2) < 1){
                pointsInCircle++;
            }
        }
        return 4*pointsInCircle/amount;
    }

    @RequestMapping("/rintegrate")
    public double rIntegration(@RequestParam(value="amount") Double amount, @RequestParam(value="nodes") Integer nodes, @RequestParam(value="nodeNumber") Integer nodeNumber){
        double nodeAmount = amount/nodes;
        double start = nodeNumber;
        double end = start + 1;
        double h = (end-start)/nodeAmount;
        double integralValue = 0;
        for(double i = start; i<end; i+=h){
            integralValue+= Math.pow(i, 3)*h;
        }
        return integralValue;
    }

    @RequestMapping("/test")
    public String test(){
        return "Test Message";
    }
}
