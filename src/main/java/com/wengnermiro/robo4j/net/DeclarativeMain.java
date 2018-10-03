/*
 * Copyright (c) 2014, 2018, Marcus Hirt, Miroslav Wengner
 *
 * Robo4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Robo4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Robo4J. If not, see <http://www.gnu.org/licenses/>.
 */

package com.wengnermiro.robo4j.net;

import com.robo4j.RoboApplication;
import com.robo4j.RoboBuilder;
import com.robo4j.RoboBuilderException;
import com.robo4j.RoboContext;
import com.robo4j.util.SystemUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * DeclarativeMain shows the declarative way of defining the Robo4J system
 *
 * steps:
 * 1. use the RoboBuilder with InputStreams for System and Context
 * 2. start the newly created system
 *
 * @author Miroslav Wengner (@miragemiko)
 */
public class DeclarativeMain {

    public static void main(String[] args) throws RoboBuilderException, IOException {
        final InputStream systemIS = Thread.currentThread().getContextClassLoader().getResourceAsStream("robo4jSystem.xml");
        final InputStream contextIS = Thread.currentThread().getContextClassLoader().getResourceAsStream("robo4jContext.xml");
        final RoboBuilder builder = new RoboBuilder(systemIS);
        builder.add(contextIS);

        final RoboContext system = builder.build();

        final RoboApplication roboApp = new RoboApplication();
        roboApp.launch(system);
    }

}
