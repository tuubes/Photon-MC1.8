/*
 * Copyright (C) 2015 ElectronWill
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.network.clientbound.play;

import java.io.IOException;
import org.mcphoton.network.SendablePacket;
import org.mcphoton.util.Location;
import org.mcphoton.util.ProtocolData;

/**
 * Used when the player join the server to tell him/her at what position he/she is. It is also used
 * to set the location the compass item points to.
 *
 * @author ElectronWill
 */
public final class SpawnPositionPacket extends SendablePacket {

	public int x, y, z;

	public SpawnPositionPacket(Location l) {
		this(l.getBlockX(), l.getBlockY(), l.getBlockZ());
	}

	public SpawnPositionPacket(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void writeTo(com.electronwill.streams.EasyOutputStream dest) throws IOException {
		dest.writeLong(ProtocolData.encodePosition(x, y, z));
	}

	@Override
	public int id() {
		return 0x05;
	}

	@Override
	public int maxDataSize() {
		return 8;
	}

}
