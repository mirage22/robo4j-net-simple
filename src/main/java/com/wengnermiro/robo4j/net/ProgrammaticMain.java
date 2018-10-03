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
import com.robo4j.configuration.Configuration;
import com.robo4j.configuration.ConfigurationBuilder;
import com.robo4j.socket.http.units.HttpServerUnit;
import com.robo4j.util.SystemUtil;

/**
 * ProgrammaticMain shows the programmatic approach of defining Robo4J system
 *
 * steps:
 * 1. use the RoboBuilder with InputStreams for System and Context
 * 2. start the newly created system
 *
 * @author Marcus Hirt (@hirt)
 * @author Miroslav Wengner (@miragemiko)
 */
public class ProgrammaticMain {

    public static void main(String[] args) throws RoboBuilderException {

        //@formatter:off
        final Configuration systemConf = new ConfigurationBuilder()
                .addInteger(RoboBuilder.KEY_SCHEDULER_POOL_SIZE, 3)
                .addInteger(RoboBuilder.KEY_WORKER_POOL_SIZE, 2)
                .addInteger(RoboBuilder.KEY_BLOCKING_POOL_SIZE, 2)
                .build();
        //@formatter:on

        //@formatter:off
        final Configuration serverUnitConf = new ConfigurationBuilder()
                .addInteger("port", 8043)
                .addString("packages", "com.robo4j.socket.http.codec")
                .addString("unitPathsConfig", "[{\"roboUnit\":\"http_server\",\"method\":\"GET\"}]")
                .build();

        final RoboContext system = new RoboBuilder("robonetSystem2", systemConf)
                .add(HttpServerUnit.class, serverUnitConf, "http_server")
                .build();
        //@formatter:on

        final RoboApplication roboApp = new RoboApplication();
        roboApp.launch(system);

    }
}
