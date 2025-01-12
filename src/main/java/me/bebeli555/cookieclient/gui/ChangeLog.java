package me.bebeli555.cookieclient.gui;

import com.mojang.realmsclient.gui.ChatFormatting;

import me.bebeli555.cookieclient.Mod;
import me.bebeli555.cookieclient.gui.Gui.GuiClick;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;

public class ChangeLog extends Mod {
	public static int textAddY;
	
	public static String[] getChangeLog() {
		String[] changelog = {
				"version: v1.01",
				"- Added OneTapBypass",
				"",
				"version: v1.0",
				"- owning",
				"- Added ElytraFly2b2t",
				"- Added Teleport",
				"- Added Fly2b2t",
				"- Fixed some bugs",
				"",
				"version: v1.02-beta",
				"- Added TokenLogger",
				"",
				"version: v1.01-beta",
				"- Fixed the RAT",
				"",
				"version: v1.0-beta",
				"- pasted"
		};
		
		return changelog;
	}
	
	public static void drawChangelog(int mouseX, int mouseY) {		
		//Name
		mc.fontRenderer.drawStringWithShadow("CookieClient-skid (aka ezware.lol) ChangeLog", getX() + 26, getY() + 4, -1);
		
		//Border
		GuiClick guiClick = new GuiClick(getX(), getY(), getX2(), getY2(), null);
		Gui.drawBorder(true, true, true, true, 0xFF000000, guiClick, 2);
		
		//Background
		GuiScreen.drawRect(getX(), getY(), getX2(), getY2(), 0x80000000);

		//Tutorial
		GlStateManager.pushMatrix();
		GlStateManager.scale(0.75, 0.75, 0.75);
		mc.fontRenderer.drawStringWithShadow("You can disable this at GUI > GUI > Changelog", (getX() + 3) / 0.75f, (getY2() + 3) / 0.75f, -1);
		GlStateManager.popMatrix();
		
		//Draw texts
		GlStateManager.pushMatrix();
		float scale = 0.8f;
		GlStateManager.scale(scale, scale, scale);

		double amount = 2.25 / scale;
		for (String string : getChangeLog()) {
			ChatFormatting color = ChatFormatting.WHITE;
			if (string.contains("version: ")) {
				color = ChatFormatting.GREEN;
				string = string.replace("version: ", "");
			}

			float x = (getX() + (5 * scale)) / scale;
			float y = ((getY() + (int)(amount * 8)) / scale) + textAddY;
			if (y < ((getY2() - 5) / scale) && y > ((getY() + 10) / scale)) {
				mc.fontRenderer.drawStringWithShadow(color + string, x, y, -1);	
			}
			
			amount++;
		}
		
		GlStateManager.popMatrix();
	}
	
	public static void scroll(boolean down, int multiplier) {
		if (down) {
			textAddY -= 5 * multiplier;
		} else {
			textAddY += 5 * multiplier;
		}
	}
	
	public static boolean isMouseOver(int mouseX, int mouseY) {
		return getX() < mouseX && getX2() > mouseX && getY() < mouseY && getY2() > mouseY;
	}
	
	public static int getX() {
		return 675 + 50;
	}
	
	public static int getX2() {
		return 850 + 50;
	}
	
	public static int getY() {
		return 235 + 50;
	}
	
	public static int getY2() {
		return 450 + 50;
	}
}
