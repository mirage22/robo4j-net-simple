package com.wengnermiro.robo4j.net;

import com.robo4j.RoboBuilder;
import com.robo4j.RoboBuilderException;
import com.robo4j.RoboContext;
import com.robo4j.util.SystemUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * AppMain starter application
 *
 * @author Miroslav Wengner (@miragemiko)
 */
public class AppMain {

    public static void main(String[] args) throws RoboBuilderException, IOException {
        final InputStream contextIS = Thread.currentThread().getContextClassLoader().getResourceAsStream("robo4j.xml");
        final RoboBuilder builder = new RoboBuilder();
        builder.add(contextIS);

        final RoboContext system = builder.build();
        system.start();
        System.out.println(SystemUtil.printStateReport(system));
        System.out.println("Press any key...");
        System.in.read();
        system.shutdown();
    }

}
