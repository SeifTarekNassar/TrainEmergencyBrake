/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.powerKnobReading;
import events.speedSensorReading;
import events.transmission;

/**
 *
 * @author seif165937
 */
public class Esper {
           private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

    public static void registerEvents() {
      
        //add events here
         engine.getEPAdministrator().getConfiguration().addEventType(powerKnobReading.class);
           engine.getEPAdministrator().getConfiguration().addEventType(speedSensorReading.class);
            engine.getEPAdministrator().getConfiguration().addEventType(transmission.class);
        System.out.println("Register Events status: Done !");
    }
    
    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement status: Done !");
        return result;
    }
    
    
    
 public static void sendEvent(Object o)
    {
        engine.getEPRuntime().sendEvent(o);
    }
 
 
 
}
