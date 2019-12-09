package misows.mcIntegration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class IntegrationController {

    @RequestMapping("/integrate")
    public double integration(@RequestParam(value="amount") Double amount){
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
}
