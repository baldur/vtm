/*
 * Copyright 2013 Hannes Janetzek
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.oscim.tiling.source;

import java.io.InputStream;
import java.io.OutputStream;

import org.oscim.core.Tile;

/*
 * Thie interface CacheManager defines the operation for the cache.
 */
public interface ITileCache {

	/**
	 * @param tile
	 *            The accessed tile.
	 * @return
	 *         The CacheFile which contains the Fileoutputstream for the cache.
	 */
	TileWriter writeTile(Tile tile);

	/**
	 * @param tile
	 *            The accessed tile.
	 * @return
	 *         The stored file for this tile.
	 */
	TileReader getTile(Tile tile);

	/**
	 * @param size
	 *            The size for the cache directionary.
	 */
	void setCacheSize(long size);

	public interface TileReader {
		Tile getTile();

		InputStream getInputStream();

		int getBytes();
	}

	public interface TileWriter {
		Tile getTile();

		OutputStream getOutputStream();

		void complete(boolean success);
	}
}
