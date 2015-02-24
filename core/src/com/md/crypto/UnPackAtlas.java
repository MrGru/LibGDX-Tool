package com.md.crypto;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class UnPackAtlas extends ApplicationAdapter {
	Pixmap pixmapUnpack;

	@Override
	public void create() {
		System.out.println("Unpack Atlas Progress:");
		TextureAtlas atlas = new TextureAtlas(
				Gdx.files.internal(Config.pathAtlas));
		for (int i = 0; i < atlas.getRegions().size; i++) {
			TextureRegion region = atlas
					.findRegion(atlas.getRegions().get(i).name);
			Pixmap px = new Pixmap(region.getRegionWidth(),
					region.getRegionHeight(), region.getTexture()
							.getTextureData().getFormat());
			int width = MathUtils.nextPowerOfTwo(region.getRegionWidth());
			int height = MathUtils.nextPowerOfTwo(region.getRegionHeight());
			int x = (width / 2) - (region.getRegionWidth() / 2);
			int y = (height / 2) - (region.getRegionHeight() / 2);
			region.getTexture().getTextureData().prepare();
			px.drawPixmap(region.getTexture().getTextureData().consumePixmap(),
					x, y, region.getRegionX(), region.getRegionY(),
					region.getRegionWidth(), region.getRegionHeight());
			PixmapIO.writePNG(
					Gdx.files.local(Config.outPath
							+ atlas.getRegions().get(i).name + ".png"), px);
			System.out.println("Write image: " + atlas.getRegions().get(i).name
					+ ".png");
		}
		System.out.println("Complete!");
		Gdx.app.exit();
	}

	@Override
	public void render() {
	}
}
