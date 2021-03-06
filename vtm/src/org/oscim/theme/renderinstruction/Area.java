/*
 * Copyright 2010, 2011, 2012 mapsforge.org
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
package org.oscim.theme.renderinstruction;

import org.oscim.backend.canvas.Color;
import org.oscim.renderer.elements.TextureItem;
import org.oscim.theme.IRenderTheme.Callback;

/**
 * Represents a closed polygon on the map.
 */
public final class Area extends RenderInstruction {

	public Area(int fill) {
		this(0, fill);
	}

	public Area(int level, int fill) {
		this.level = level;
		this.style = "";
		this.fade = -1;
		this.blendColor = 0;
		this.blend = -1;
		this.color = fill;
		this.texture = null;
		this.outline = null;
	}

	public Area(String style, int fill, int stroke, float strokeWidth,
	        int fade, int level, int blend, int blendFill, TextureItem texture) {

		this.style = style;
		this.color = fill;
		this.blendColor = blendFill;
		this.blend = blend;
		this.fade = fade;
		this.level = level;
		this.texture = texture;

		if (stroke == Color.TRANSPARENT) {
			this.outline = null;
			return;
		}

		this.outline = new Line(level + 1, stroke, strokeWidth);
	}

	@Override
	public void renderWay(Callback renderCallback) {
		renderCallback.renderArea(this, level);

		if (outline != null)
			renderCallback.renderWay(outline, level + 1);
	}

	private final int level;
	public String style;
	public final Line outline;
	public final int color;
	public final int fade;
	public final int blendColor;
	public final int blend;
	public final TextureItem texture;
}
