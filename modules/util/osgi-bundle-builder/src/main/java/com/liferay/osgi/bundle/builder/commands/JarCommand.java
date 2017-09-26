/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.osgi.bundle.builder.commands;

import aQute.bnd.osgi.Jar;

import java.io.File;

import java.nio.file.Files;

/**
 * @author David Truong
 */
public class JarCommand extends BaseCommand {

	@Override
	public void writeOutput(Jar jar) throws Exception {
		File output = getOutput();

		Files.createDirectories(output.toPath());

		if (output.isFile()) {
			jar.write(output);
		}
		else {
			jar.write(new File(output, jar.getName() + ".jar"));
		}
	}

}